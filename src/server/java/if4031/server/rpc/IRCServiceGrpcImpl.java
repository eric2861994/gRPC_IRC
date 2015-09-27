package if4031.server.rpc;

import if4031.common.*;
import if4031.server.IRCData;
import if4031.server.exception.ChannelException;
import io.grpc.stub.StreamObserver;

import java.util.List;

/**
 * Created by nim_13512065 on 9/27/15.
 */
public class IRCServiceGrpcImpl implements IRCServiceGrpc.IRCService {

    private IRCData ircData;
    public IRCServiceGrpcImpl() {
        this.setIrcData(new IRCData());
    }

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        int userId = ircData.login(request.getNickname());
        LoginResponse.Builder builder = LoginResponse.newBuilder().setUserID(userId);
        builder.setStatus(ResponseStatus.OK);
        LoginResponse loginResponse = builder.build();
        responseObserver.onValue(loginResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void changeNickname(ChangeNickRequest request, StreamObserver<StatusResponse> responseObserver) {
        boolean status = ircData.changeNick(request.getUser(), request.getNewNickname());
        StatusResponse.Builder builder = StatusResponse.newBuilder();
        if (status) {
            builder.setStatus(ResponseStatus.OK);
        } else {
            builder.setStatus(ResponseStatus.NOT_OK);
        }
        StatusResponse statusResponse = builder.build();
        responseObserver.onValue(statusResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void logout(ActionRequest request, StreamObserver<StatusResponse> responseObserver) {
        boolean status = ircData.logout(request.getUser());
        StatusResponse.Builder builder = StatusResponse.newBuilder();
        if (status) {
            builder.setStatus(ResponseStatus.OK);
        } else {
            builder.setStatus(ResponseStatus.NOT_OK);
        }
        StatusResponse statusResponse = builder.build();
        responseObserver.onValue(statusResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void joinChannel(ChannelRequest request, StreamObserver<StatusResponse> responseObserver) {
        boolean status;
        StatusResponse.Builder builder = StatusResponse.newBuilder();
        try {
            status = ircData.joinChannel(request.getUser(), request.getChannel());
        } catch (ChannelException e) {
            status = false;
            e.printStackTrace();
        }

        if (status) {
            builder.setStatus(ResponseStatus.OK);
        } else {
            builder.setStatus(ResponseStatus.NOT_OK);
        }

        StatusResponse statusResponse = builder.build();
        responseObserver.onValue(statusResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getMessage(ActionRequest request, StreamObserver<MessagesResponse> responseObserver) {
        List<Message> messages = ircData.getMessage(request.getUser());
        MessagesResponse messagesResponse = messagesListConverter(messages);
        responseObserver.onValue(messagesResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void sendMessageToChannel(ChannelMessageRequest request, StreamObserver<MessagesResponse> responseObserver) {
        List<Message> messages = ircData.sendMessageToChannel(request.getUser(), request.getChannel(), request.getMessage());
        MessagesResponse messagesResponse = messagesListConverter(messages);
        responseObserver.onValue(messagesResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void sendMessage(MessageRequest request, StreamObserver<MessagesResponse> responseObserver) {
        List<Message> messages = ircData.sendMessage(request.getUser(), request.getMessage());
        MessagesResponse messagesResponse = messagesListConverter(messages);
        responseObserver.onValue(messagesResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void leaveChannel(ChannelRequest request, StreamObserver<StatusResponse> responseObserver) {
        boolean status = ircData.leaveChannel(request.getUser(), request.getChannel());
        StatusResponse.Builder builder = StatusResponse.newBuilder();
        if (status) {
            builder.setStatus(ResponseStatus.OK);
        } else {
            builder.setStatus(ResponseStatus.NOT_OK);
        }
        StatusResponse statusResponse = builder.build();
        responseObserver.onValue(statusResponse);
        responseObserver.onCompleted();
    }

    public static MessagesResponse messagesListConverter(List<Message> messages) {
        MessagesResponse.Builder builder = MessagesResponse.newBuilder();
        for (int i = 0; i < messages.size(); ++i) {
            builder = builder.setMessages(i, messages.get(i));
        }
        MessagesResponse messagesResponse = builder.build();
        return messagesResponse;
    }

    public IRCData getIrcData() {
        return ircData;
    }

    public void setIrcData(IRCData ircData) {
        this.ircData = ircData;
    }
}
