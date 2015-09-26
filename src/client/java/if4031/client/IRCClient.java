package if4031.client;

import if4031.client.command.Command;
import if4031.client.command.IRCCommandFactory;
import if4031.client.executor.DelayableRepeatingExecutor;
import if4031.client.executor.ToleratingTimedExecutor;
import if4031.client.rpc.GRPCClient;
import if4031.client.rpc.Message;
import if4031.client.rpc.RPCClient;
import if4031.client.rpc.RPCException;
import if4031.common.IRCServiceGrpc;
import io.grpc.ChannelImpl;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

// TODO this is the main program
public class IRCClient {

    private final IRCCommandFactory ircCommandFactory = new IRCCommandFactory();
    private final RPCClient rpcClient;
    private final ChannelImpl channel;
    private final ToleratingTimedExecutor toleratingExecutor;
    private final DelayableRepeatingExecutor executorService;

    private IRCClientListener ircClientListener;
    private String nickname;
    private int userID;
    private int channelCount;

    private ClientState clientState = ClientState.LOGGED_OUT;

    IRCClient(String server, int port, int refreshMillis, int toleranceMillis) {
        channel = NettyChannelBuilder.forAddress(server, port).negotiationType(NegotiationType.PLAINTEXT).build();
        IRCServiceGrpc.IRCServiceBlockingStub client = IRCServiceGrpc.newBlockingStub(channel);
        rpcClient = new GRPCClient(client);

        toleratingExecutor = new ToleratingTimedExecutor(new Runnable() {
            @Override
            public void run() {
                realGetMessages();
            }
        }, refreshMillis, toleranceMillis);
        executorService = toleratingExecutor;
    }

    void start() {
        toleratingExecutor.initialize();
    }

    void stop() throws InterruptedException {
        channel.awaitTermination(5, TimeUnit.SECONDS);
        toleratingExecutor.shutdown();
    }

    private void monitorThreadState() {
        if (clientState == ClientState.JOINED_CHANNEL &&
                executorService.getStatus() == DelayableRepeatingExecutor.ExecutorState.STOPPED) {
            executorService.start();

        } else if (clientState != ClientState.JOINED_CHANNEL &&
                executorService.getStatus() == DelayableRepeatingExecutor.ExecutorState.STARTED) {
            executorService.stop();
        }
    }

    private void setState(ClientState _clientState) {
        clientState = _clientState;
        monitorThreadState();
    }

    public void setIrcClientListener(IRCClientListener _ircClientListener) {
        ircClientListener = _ircClientListener;
    }

    // BEGIN RPC actions

    public void changeNickname(String newNickname) {
        try {
            boolean successful = rpcClient.changeNickname(userID, newNickname);
            nickname = newNickname;
            ircClientListener.notifyNicknameChange(newNickname);

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    private void realGetMessages() {
        try {
            List<Message> messages = rpcClient.getMessages(userID);
            ircClientListener.notifyMessageArrive(messages);

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    public void getMessages() {
        if (executorService.getStatus() == DelayableRepeatingExecutor.ExecutorState.STARTED) {
            executorService.mark();

        } else {
            // TODO harusnya ini tidak penah terjadi
            realGetMessages();
        }
    }

    public void joinChannel(String channelName) {
        try {
            rpcClient.joinChannel(userID, channelName);
            channelCount++;
            setState(ClientState.JOINED_CHANNEL);
            ircClientListener.notifyJoinChannel(channelName);

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    public void leaveChannel(String channelName) {
        try {
            rpcClient.leaveChannel(userID, channelName);
            channelCount--;
            if (channelCount == 0) {
                setState(ClientState.LOGGED_IN);
            }

            ircClientListener.notifyLeaveChannel(channelName);

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    void login(String nickname) {
        try {
            userID = rpcClient.login(nickname);
            setState(ClientState.LOGGED_IN);
            ircClientListener.notifyLogin();

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    void logout() {
        try {
            rpcClient.logout(userID);
            setState(ClientState.LOGGED_OUT);
            ircClientListener.notifyLogout();

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageAll(String message) {
        try {
            List<Message> messages = rpcClient.sendMessage(userID, message);
            ircClientListener.notifyMessageArrive(messages);

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageChannel(String channelName, String message) {
        try {
            List<Message> messages = rpcClient.sendMessageToChannel(userID, channelName, message);
            ircClientListener.notifyMessageArrive(messages);

        } catch (RPCException e) {
            e.printStackTrace();
        }
    }

    // END RPC actions

    void parseExecute(String line) {
        IRCCommandFactory.ParseResult parseResult = ircCommandFactory.parse(line);

        IRCCommandFactory.ParseStatus status = parseResult.getStatus();
        if (status == IRCCommandFactory.ParseStatus.OK) {
            Command command = parseResult.getCommand();
            command.execute(this);
        }
    }

    private enum ClientState {
        JOINED_CHANNEL,
        LOGGED_IN,
        LOGGED_OUT
    }
}
