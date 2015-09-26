package if4031.common;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class IRCServiceGrpc {

  // Static method descriptors that strictly reflect the proto.
  public static final io.grpc.MethodDescriptor<if4031.common.LoginRequest,
      if4031.common.LoginResponse> METHOD_LOGIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "login",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.LoginRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.LoginResponse.parser()));
  public static final io.grpc.MethodDescriptor<if4031.common.ChangeNickRequest,
      if4031.common.StatusResponse> METHOD_CHANGE_NICKNAME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "changeNickname",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.ChangeNickRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<if4031.common.ActionRequest,
      if4031.common.StatusResponse> METHOD_LOGOUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "logout",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.ActionRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<if4031.common.ChannelRequest,
      if4031.common.StatusResponse> METHOD_JOIN_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "joinChannel",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.ChannelRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.StatusResponse.parser()));
  public static final io.grpc.MethodDescriptor<if4031.common.ActionRequest,
      if4031.common.MessagesResponse> METHOD_GET_MESSAGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "getMessage",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.ActionRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.MessagesResponse.parser()));
  public static final io.grpc.MethodDescriptor<if4031.common.ChannelMessageRequest,
      if4031.common.MessagesResponse> METHOD_SEND_MESSAGE_TO_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "sendMessageToChannel",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.ChannelMessageRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.MessagesResponse.parser()));
  public static final io.grpc.MethodDescriptor<if4031.common.MessageRequest,
      if4031.common.MessagesResponse> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "sendMessage",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.MessageRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.MessagesResponse.parser()));
  public static final io.grpc.MethodDescriptor<if4031.common.ChannelRequest,
      if4031.common.StatusResponse> METHOD_LEAVE_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "if4031.IRCService", "leaveChannel",
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.ChannelRequest.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(if4031.common.StatusResponse.parser()));

  public static IRCServiceStub newStub(io.grpc.Channel channel) {
    return new IRCServiceStub(channel);
  }

  public static IRCServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new IRCServiceBlockingStub(channel);
  }

  public static IRCServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new IRCServiceFutureStub(channel);
  }

  public static interface IRCService {

    public void login(if4031.common.LoginRequest request,
        io.grpc.stub.StreamObserver<if4031.common.LoginResponse> responseObserver);

    public void changeNickname(if4031.common.ChangeNickRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver);

    public void logout(if4031.common.ActionRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver);

    public void joinChannel(if4031.common.ChannelRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver);

    public void getMessage(if4031.common.ActionRequest request,
        io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver);

    public void sendMessageToChannel(if4031.common.ChannelMessageRequest request,
        io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver);

    public void sendMessage(if4031.common.MessageRequest request,
        io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver);

    public void leaveChannel(if4031.common.ChannelRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver);
  }

  public static interface IRCServiceBlockingClient {

    public if4031.common.LoginResponse login(if4031.common.LoginRequest request);

    public if4031.common.StatusResponse changeNickname(if4031.common.ChangeNickRequest request);

    public if4031.common.StatusResponse logout(if4031.common.ActionRequest request);

    public if4031.common.StatusResponse joinChannel(if4031.common.ChannelRequest request);

    public if4031.common.MessagesResponse getMessage(if4031.common.ActionRequest request);

    public if4031.common.MessagesResponse sendMessageToChannel(if4031.common.ChannelMessageRequest request);

    public if4031.common.MessagesResponse sendMessage(if4031.common.MessageRequest request);

    public if4031.common.StatusResponse leaveChannel(if4031.common.ChannelRequest request);
  }

  public static interface IRCServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.LoginResponse> login(
        if4031.common.LoginRequest request);

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> changeNickname(
        if4031.common.ChangeNickRequest request);

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> logout(
        if4031.common.ActionRequest request);

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> joinChannel(
        if4031.common.ChannelRequest request);

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.MessagesResponse> getMessage(
        if4031.common.ActionRequest request);

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.MessagesResponse> sendMessageToChannel(
        if4031.common.ChannelMessageRequest request);

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.MessagesResponse> sendMessage(
        if4031.common.MessageRequest request);

    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> leaveChannel(
        if4031.common.ChannelRequest request);
  }

  public static class IRCServiceStub extends io.grpc.stub.AbstractStub<IRCServiceStub>
      implements IRCService {
    private IRCServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void login(if4031.common.LoginRequest request,
        io.grpc.stub.StreamObserver<if4031.common.LoginResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_LOGIN, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void changeNickname(if4031.common.ChangeNickRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_CHANGE_NICKNAME, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void logout(if4031.common.ActionRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_LOGOUT, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void joinChannel(if4031.common.ChannelRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_JOIN_CHANNEL, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void getMessage(if4031.common.ActionRequest request,
        io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_GET_MESSAGE, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void sendMessageToChannel(if4031.common.ChannelMessageRequest request,
        io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE_TO_CHANNEL, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void sendMessage(if4031.common.MessageRequest request,
        io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void leaveChannel(if4031.common.ChannelRequest request,
        io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_LEAVE_CHANNEL, callOptions), request, responseObserver);
    }
  }

  public static class IRCServiceBlockingStub extends io.grpc.stub.AbstractStub<IRCServiceBlockingStub>
      implements IRCServiceBlockingClient {
    private IRCServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public if4031.common.LoginResponse login(if4031.common.LoginRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_LOGIN, callOptions), request);
    }

    @java.lang.Override
    public if4031.common.StatusResponse changeNickname(if4031.common.ChangeNickRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_CHANGE_NICKNAME, callOptions), request);
    }

    @java.lang.Override
    public if4031.common.StatusResponse logout(if4031.common.ActionRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_LOGOUT, callOptions), request);
    }

    @java.lang.Override
    public if4031.common.StatusResponse joinChannel(if4031.common.ChannelRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_JOIN_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public if4031.common.MessagesResponse getMessage(if4031.common.ActionRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_GET_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public if4031.common.MessagesResponse sendMessageToChannel(if4031.common.ChannelMessageRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE_TO_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public if4031.common.MessagesResponse sendMessage(if4031.common.MessageRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public if4031.common.StatusResponse leaveChannel(if4031.common.ChannelRequest request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_LEAVE_CHANNEL, callOptions), request);
    }
  }

  public static class IRCServiceFutureStub extends io.grpc.stub.AbstractStub<IRCServiceFutureStub>
      implements IRCServiceFutureClient {
    private IRCServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.LoginResponse> login(
        if4031.common.LoginRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_LOGIN, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> changeNickname(
        if4031.common.ChangeNickRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_CHANGE_NICKNAME, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> logout(
        if4031.common.ActionRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_LOGOUT, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> joinChannel(
        if4031.common.ChannelRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_JOIN_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.MessagesResponse> getMessage(
        if4031.common.ActionRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_GET_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.MessagesResponse> sendMessageToChannel(
        if4031.common.ChannelMessageRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE_TO_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.MessagesResponse> sendMessage(
        if4031.common.MessageRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<if4031.common.StatusResponse> leaveChannel(
        if4031.common.ChannelRequest request) {
      return futureUnaryCall(
          channel.newCall(METHOD_LEAVE_CHANNEL, callOptions), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final IRCService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder("if4031.IRCService")
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_LOGIN,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.LoginRequest,
                if4031.common.LoginResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.LoginRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.LoginResponse> responseObserver) {
                serviceImpl.login(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_CHANGE_NICKNAME,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.ChangeNickRequest,
                if4031.common.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.ChangeNickRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
                serviceImpl.changeNickname(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_LOGOUT,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.ActionRequest,
                if4031.common.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.ActionRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
                serviceImpl.logout(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_JOIN_CHANNEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.ChannelRequest,
                if4031.common.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.ChannelRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
                serviceImpl.joinChannel(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_GET_MESSAGE,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.ActionRequest,
                if4031.common.MessagesResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.ActionRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver) {
                serviceImpl.getMessage(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_SEND_MESSAGE_TO_CHANNEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.ChannelMessageRequest,
                if4031.common.MessagesResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.ChannelMessageRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver) {
                serviceImpl.sendMessageToChannel(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_SEND_MESSAGE,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.MessageRequest,
                if4031.common.MessagesResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.MessageRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.MessagesResponse> responseObserver) {
                serviceImpl.sendMessage(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_LEAVE_CHANNEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                if4031.common.ChannelRequest,
                if4031.common.StatusResponse>() {
              @java.lang.Override
              public void invoke(
                  if4031.common.ChannelRequest request,
                  io.grpc.stub.StreamObserver<if4031.common.StatusResponse> responseObserver) {
                serviceImpl.leaveChannel(request, responseObserver);
              }
            }))).build();
  }
}
