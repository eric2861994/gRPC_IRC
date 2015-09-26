// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IRCService.proto

package if4031.common;

public final class IRCServiceOuterClass {
  private IRCServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_ChannelMessageRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_ChannelMessageRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_MessageRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_MessageRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_ChangeNickRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_ChangeNickRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_ChannelRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_ChannelRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_LoginRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_LoginRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_ActionRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_ActionRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_LoginResponse_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_LoginResponse_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_StatusResponse_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_StatusResponse_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_Message_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_Message_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_if4031_MessagesResponse_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_if4031_MessagesResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020IRCService.proto\022\006if4031\"G\n\025ChannelMes" +
      "sageRequest\022\014\n\004user\030\001 \001(\005\022\017\n\007channel\030\002 \001" +
      "(\t\022\017\n\007message\030\003 \001(\t\"/\n\016MessageRequest\022\014\n" +
      "\004user\030\001 \001(\005\022\017\n\007message\030\002 \001(\t\"6\n\021ChangeNi" +
      "ckRequest\022\014\n\004user\030\001 \001(\005\022\023\n\013newNickname\030\002" +
      " \001(\t\"/\n\016ChannelRequest\022\014\n\004user\030\001 \001(\005\022\017\n\007" +
      "channel\030\002 \001(\t\" \n\014LoginRequest\022\020\n\010nicknam" +
      "e\030\001 \001(\t\"\035\n\rActionRequest\022\014\n\004user\030\001 \001(\005\"W" +
      "\n\rLoginResponse\022\016\n\006userID\030\001 \001(\005\022&\n\006statu" +
      "s\030\002 \001(\0162\026.if4031.ResponseStatus\022\016\n\006reaso",
      "n\030\003 \001(\t\"H\n\016StatusResponse\022&\n\006status\030\001 \001(" +
      "\0162\026.if4031.ResponseStatus\022\016\n\006reason\030\002 \001(" +
      "\t\"J\n\007Message\022\016\n\006sender\030\001 \001(\t\022\017\n\007channel\030" +
      "\002 \001(\t\022\014\n\004body\030\003 \001(\t\022\020\n\010sendTime\030\004 \001(\003\"5\n" +
      "\020MessagesResponse\022!\n\010messages\030\001 \003(\0132\017.if" +
      "4031.Message*$\n\016ResponseStatus\022\006\n\002OK\020\000\022\n" +
      "\n\006NOT_OK\020\0012\240\004\n\nIRCService\0226\n\005login\022\024.if4" +
      "031.LoginRequest\032\025.if4031.LoginResponse\"" +
      "\000\022E\n\016changeNickname\022\031.if4031.ChangeNickR" +
      "equest\032\026.if4031.StatusResponse\"\000\0229\n\006logo",
      "ut\022\025.if4031.ActionRequest\032\026.if4031.Statu" +
      "sResponse\"\000\022?\n\013joinChannel\022\026.if4031.Chan" +
      "nelRequest\032\026.if4031.StatusResponse\"\000\022?\n\n" +
      "getMessage\022\025.if4031.ActionRequest\032\030.if40" +
      "31.MessagesResponse\"\000\022Q\n\024sendMessageToCh" +
      "annel\022\035.if4031.ChannelMessageRequest\032\030.i" +
      "f4031.MessagesResponse\"\000\022A\n\013sendMessage\022" +
      "\026.if4031.MessageRequest\032\030.if4031.Message" +
      "sResponse\"\000\022@\n\014leaveChannel\022\026.if4031.Cha" +
      "nnelRequest\032\026.if4031.StatusResponse\"\000B\021\n",
      "\rif4031.commonP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_if4031_ChannelMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_if4031_ChannelMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_ChannelMessageRequest_descriptor,
        new java.lang.String[] { "User", "Channel", "Message", });
    internal_static_if4031_MessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_if4031_MessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_MessageRequest_descriptor,
        new java.lang.String[] { "User", "Message", });
    internal_static_if4031_ChangeNickRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_if4031_ChangeNickRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_ChangeNickRequest_descriptor,
        new java.lang.String[] { "User", "NewNickname", });
    internal_static_if4031_ChannelRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_if4031_ChannelRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_ChannelRequest_descriptor,
        new java.lang.String[] { "User", "Channel", });
    internal_static_if4031_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_if4031_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_LoginRequest_descriptor,
        new java.lang.String[] { "Nickname", });
    internal_static_if4031_ActionRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_if4031_ActionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_ActionRequest_descriptor,
        new java.lang.String[] { "User", });
    internal_static_if4031_LoginResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_if4031_LoginResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_LoginResponse_descriptor,
        new java.lang.String[] { "UserID", "Status", "Reason", });
    internal_static_if4031_StatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_if4031_StatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_StatusResponse_descriptor,
        new java.lang.String[] { "Status", "Reason", });
    internal_static_if4031_Message_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_if4031_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_Message_descriptor,
        new java.lang.String[] { "Sender", "Channel", "Body", "SendTime", });
    internal_static_if4031_MessagesResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_if4031_MessagesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_if4031_MessagesResponse_descriptor,
        new java.lang.String[] { "Messages", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}