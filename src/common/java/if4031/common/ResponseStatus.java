// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IRCService.proto

package if4031.common;

/**
 * Protobuf enum {@code if4031.ResponseStatus}
 */
public enum ResponseStatus
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>OK = 0;</code>
   */
  OK(0, 0),
  /**
   * <code>NOT_OK = 1;</code>
   */
  NOT_OK(1, 1),
  UNRECOGNIZED(-1, -1),
  ;

  /**
   * <code>OK = 0;</code>
   */
  public static final int OK_VALUE = 0;
  /**
   * <code>NOT_OK = 1;</code>
   */
  public static final int NOT_OK_VALUE = 1;


  public final int getNumber() {
    if (index == -1) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  public static ResponseStatus valueOf(int value) {
    switch (value) {
      case 0: return OK;
      case 1: return NOT_OK;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ResponseStatus>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ResponseStatus> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ResponseStatus>() {
          public ResponseStatus findValueByNumber(int number) {
            return ResponseStatus.valueOf(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(index);
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return if4031.common.IRCServiceOuterClass.getDescriptor()
        .getEnumTypes().get(0);
  }

  private static final ResponseStatus[] VALUES = values();

  public static ResponseStatus valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int index;
  private final int value;

  private ResponseStatus(int index, int value) {
    this.index = index;
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:if4031.ResponseStatus)
}

