// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IRCService.proto

package if4031.common;

public interface ChannelMessageRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:if4031.ChannelMessageRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 user = 1;</code>
   */
  int getUser();

  /**
   * <code>optional string channel = 2;</code>
   */
  java.lang.String getChannel();
  /**
   * <code>optional string channel = 2;</code>
   */
  com.google.protobuf.ByteString
      getChannelBytes();

  /**
   * <code>optional string message = 3;</code>
   */
  java.lang.String getMessage();
  /**
   * <code>optional string message = 3;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}