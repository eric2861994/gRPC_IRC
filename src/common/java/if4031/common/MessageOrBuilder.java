// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IRCService.proto

package if4031.common;

public interface MessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:if4031.Message)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string sender = 1;</code>
   */
  java.lang.String getSender();
  /**
   * <code>optional string sender = 1;</code>
   */
  com.google.protobuf.ByteString
      getSenderBytes();

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
   * <code>optional string body = 3;</code>
   */
  java.lang.String getBody();
  /**
   * <code>optional string body = 3;</code>
   */
  com.google.protobuf.ByteString
      getBodyBytes();

  /**
   * <code>optional int64 sendTime = 4;</code>
   */
  long getSendTime();
}