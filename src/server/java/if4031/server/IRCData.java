package if4031.server;

import if4031.common.Message;
import if4031.server.exception.ChannelException;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nim_13512065 on 9/17/15.
 */
public class IRCData {
    private static int pointer = 1;
    private List<IRCChannel> ircChannels;
    private List<IRCUser> ircUsers;
    public IRCData() {
        this.setIrcChannels(new ArrayList<IRCChannel>());
        this.setIrcUsers(new ArrayList<IRCUser>());
    }

    public IRCData (IRCData ircData) {
        this.setIrcChannels(new ArrayList<IRCChannel>());
        for (IRCChannel ircChannel : ircData.getIrcChannels()) {
            this.getIrcChannels().add(ircChannel);
        }

        this.setIrcUsers(new ArrayList<IRCUser>());
        for (IRCUser ircUser : ircData.getIrcUsers()) {
            this.getIrcUsers().add(ircUser);
        }
    }

    public void addUser () {
        int uid = this.generateUserId();
        String nickname = this.generateNickname();
        IRCUser ircUser = new IRCUser(uid, nickname);
        this.ircUsers.add(ircUser);
    }

    public IRCUser findIRCUserByUserId(int userId) {
        for (IRCUser ircuser : this.getIrcUsers()) {
            if (ircuser.getUserId() == userId) {
                return ircuser;
            }
        }

        return null;
    }

    public IRCChannel findIRCChannel (String channel) {
        for (IRCChannel ircChannel : this.getIrcChannels()) {
            if (ircChannel.getChannelName().equals(channel)) {
                return ircChannel;
            }
        }

        return null;
    }

    public boolean changeNick(int userId, String nickname) {
        for (IRCUser ircuser : this.getIrcUsers()) {
            if (ircuser.getUserId() == userId) {
                ircuser.setNickname(nickname);
                return true;
            }
        }
        return false;
    }

    public String generateNickname() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    private synchronized int generateUserId() {
        int ret = pointer;
        pointer++;
        return ret;
    }


    public List<IRCChannel> getIrcChannels() {
        return ircChannels;
    }

    public void setIrcChannels(List<IRCChannel> ircChannels) {
        this.ircChannels = ircChannels;
    }

    public List<IRCUser> getIrcUsers() {
        return ircUsers;
    }


    public void setIrcUsers(List<IRCUser> ircUsers) {
        this.ircUsers = ircUsers;
    }


    public int login(String nickname) {
        int uid = this.generateUserId();
        if (this.isNicknameExists(nickname)) {
            return -1;
        } else {
            IRCUser ircUser = new IRCUser(uid, nickname);
            this.ircUsers.add(ircUser);
            return uid;
        }
    }

    private boolean isNicknameExists(String nickname) {
        return (this.findIRCUserByNickname(nickname) != null);
    }

    private IRCUser findIRCUserByNickname(String nickname) {
        for (IRCUser ircuser : this.getIrcUsers()) {
            if (ircuser.getNickname().equals(nickname)) {
                return ircuser;
            }
        }
        return null;
    }

    public boolean logout(int user) {
        IRCUser ircUser = this.findIRCUserByUserId(user);
        this.getIrcUsers().remove(ircUser);
        if (this.getIrcChannels().size() > 0) {
            for (IRCChannel ircChannel : this.getIrcChannels()) {
                ircChannel.removeUser(ircUser.getUserId());
            }
        }
        return true;
    }

    public boolean joinChannel(int user, String channel) throws ChannelException {
        IRCUser ircUser = this.findIRCUserByUserId(user);
        IRCChannel ircChannel = this.findIRCChannel(channel);
        if (ircChannel == null) {
            IRCChannel newircChannel = new IRCChannel(channel);
            newircChannel.addUser(user);
            this.getIrcChannels().add(newircChannel);

            ircUser.addIRCChannels(channel); //reference
        } else {
            ircChannel.addUser(user);
            ircUser.addIRCChannels(ircChannel.getChannelName());
        }
        return true;
    }

    public List<Message> getMessage(int user) {
        IRCUser ircUser = this.findIRCUserByUserId(user);
        List<Message> messages = new ArrayList<Message> (ircUser.getMessages());
        ircUser.deleteMessageAtAllChannel();
        return messages;
    }

    public boolean leaveChannel(int user, String channel) throws ChannelException {
        IRCUser ircUser = this.findIRCUserByUserId(user);
        IRCChannel removed = ircUser.removeIRCChannel(channel);
        IRCChannel ircChannel = this.findIRCChannel(removed.getChannelName());
        ircChannel.removeUser(user);
        return true;
    }

    public List<Message> sendMessageToChannel(int user, String channel, String messageBody) {
        Message.Builder messageBuilder = Message.newBuilder().setBody(messageBody);
        IRCUser myIRCUser = this.findIRCUserByUserId(user);

        Message message = messageBuilder.setSender(myIRCUser.getNickname()).setChannel(channel).setSendTime(System.currentTimeMillis()).build();


        IRCChannel ircChannel = this.findIRCChannel(channel);
        if (ircChannel != null) {
            List<Integer> recipients = ircChannel.getIntegers();
            for (Integer recipient : recipients) {
                if (recipient != null) {
                    IRCUser ircUser = this.findIRCUserByUserId(recipient);
                    ircUser.addMessage(Message.newBuilder(message).build());
                }
            }
        }
        List<Message> ret = new ArrayList<>(myIRCUser.getMessages());
        myIRCUser.deleteMessageAtAllChannel();
        return ret;

//        List<Message> ms = myIRCUser.getMessages();
//        List<Message> retms = new ArrayList<>();
//        for (Message m : ms) {
//            if (m.getChannel().equals(channel)) {
//                retms.add(new Message(m));
//            }
//        }
//
//        myIRCUser.deleteMessageAtChannel(channel);
//        return retms;
    }

    public List<Message> sendMessage(int user, String messageBody) {
        Message.Builder messageBuilder = Message.newBuilder().setBody(messageBody);
        IRCUser myIRCUser = this.findIRCUserByUserId(user);
        messageBuilder = messageBuilder.setSender(myIRCUser.getNickname()).setSendTime(System.currentTimeMillis());

        List<String> ircChannelNames = myIRCUser.getIrcChannelNames();
        for (String ircChannelName : ircChannelNames) {
            messageBuilder = messageBuilder.setChannel(ircChannelName);
            Message message = messageBuilder.build();
            IRCChannel ircChannel = this.findIRCChannel(ircChannelName);
            List<Integer> recipients = ircChannel.getIntegers();
            for (Integer recipient : recipients) {
                if (recipient != null) {
                    IRCUser ircUser = this.findIRCUserByUserId(recipient);
                    ircUser.addMessage(Message.newBuilder(message).build());
                }
            }
        }
        List<Message> ret = new ArrayList<>(myIRCUser.getMessages());
        myIRCUser.deleteMessageAtAllChannel();
        return ret;
    }
}
