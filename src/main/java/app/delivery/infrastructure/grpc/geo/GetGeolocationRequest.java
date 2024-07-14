// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: Geo.proto
// Protobuf Java Version: 4.27.2

package app.delivery.infrastructure.grpc.geo;

/**
 * <pre>
 * Request
 * </pre>
 *
 * Protobuf type {@code app.delivery.infrastructure.grpc.geo.GetGeolocationRequest}
 */
public final class GetGeolocationRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:app.delivery.infrastructure.grpc.geo.GetGeolocationRequest)
    GetGeolocationRequestOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      GetGeolocationRequest.class.getName());
  }
  // Use GetGeolocationRequest.newBuilder() to construct.
  private GetGeolocationRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GetGeolocationRequest() {
    street_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return app.delivery.infrastructure.grpc.geo.GeoOuterClass.internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return app.delivery.infrastructure.grpc.geo.GeoOuterClass.internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            app.delivery.infrastructure.grpc.geo.GetGeolocationRequest.class, app.delivery.infrastructure.grpc.geo.GetGeolocationRequest.Builder.class);
  }

  public static final int STREET_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object street_ = "";
  /**
   * <code>string Street = 1;</code>
   * @return The street.
   */
  @java.lang.Override
  public java.lang.String getStreet() {
    java.lang.Object ref = street_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      street_ = s;
      return s;
    }
  }
  /**
   * <code>string Street = 1;</code>
   * @return The bytes for street.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getStreetBytes() {
    java.lang.Object ref = street_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      street_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(street_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, street_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(street_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, street_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof app.delivery.infrastructure.grpc.geo.GetGeolocationRequest)) {
      return super.equals(obj);
    }
    app.delivery.infrastructure.grpc.geo.GetGeolocationRequest other = (app.delivery.infrastructure.grpc.geo.GetGeolocationRequest) obj;

    if (!getStreet()
        .equals(other.getStreet())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STREET_FIELD_NUMBER;
    hash = (53 * hash) + getStreet().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(app.delivery.infrastructure.grpc.geo.GetGeolocationRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Request
   * </pre>
   *
   * Protobuf type {@code app.delivery.infrastructure.grpc.geo.GetGeolocationRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:app.delivery.infrastructure.grpc.geo.GetGeolocationRequest)
      app.delivery.infrastructure.grpc.geo.GetGeolocationRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return app.delivery.infrastructure.grpc.geo.GeoOuterClass.internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return app.delivery.infrastructure.grpc.geo.GeoOuterClass.internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              app.delivery.infrastructure.grpc.geo.GetGeolocationRequest.class, app.delivery.infrastructure.grpc.geo.GetGeolocationRequest.Builder.class);
    }

    // Construct using app.delivery.infrastructure.grpc.geo.GetGeolocationRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      street_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return app.delivery.infrastructure.grpc.geo.GeoOuterClass.internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_descriptor;
    }

    @java.lang.Override
    public app.delivery.infrastructure.grpc.geo.GetGeolocationRequest getDefaultInstanceForType() {
      return app.delivery.infrastructure.grpc.geo.GetGeolocationRequest.getDefaultInstance();
    }

    @java.lang.Override
    public app.delivery.infrastructure.grpc.geo.GetGeolocationRequest build() {
      app.delivery.infrastructure.grpc.geo.GetGeolocationRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public app.delivery.infrastructure.grpc.geo.GetGeolocationRequest buildPartial() {
      app.delivery.infrastructure.grpc.geo.GetGeolocationRequest result = new app.delivery.infrastructure.grpc.geo.GetGeolocationRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(app.delivery.infrastructure.grpc.geo.GetGeolocationRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.street_ = street_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof app.delivery.infrastructure.grpc.geo.GetGeolocationRequest) {
        return mergeFrom((app.delivery.infrastructure.grpc.geo.GetGeolocationRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(app.delivery.infrastructure.grpc.geo.GetGeolocationRequest other) {
      if (other == app.delivery.infrastructure.grpc.geo.GetGeolocationRequest.getDefaultInstance()) return this;
      if (!other.getStreet().isEmpty()) {
        street_ = other.street_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              street_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object street_ = "";
    /**
     * <code>string Street = 1;</code>
     * @return The street.
     */
    public java.lang.String getStreet() {
      java.lang.Object ref = street_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        street_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Street = 1;</code>
     * @return The bytes for street.
     */
    public com.google.protobuf.ByteString
        getStreetBytes() {
      java.lang.Object ref = street_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        street_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Street = 1;</code>
     * @param value The street to set.
     * @return This builder for chaining.
     */
    public Builder setStreet(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      street_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string Street = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStreet() {
      street_ = getDefaultInstance().getStreet();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string Street = 1;</code>
     * @param value The bytes for street to set.
     * @return This builder for chaining.
     */
    public Builder setStreetBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      street_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:app.delivery.infrastructure.grpc.geo.GetGeolocationRequest)
  }

  // @@protoc_insertion_point(class_scope:app.delivery.infrastructure.grpc.geo.GetGeolocationRequest)
  private static final app.delivery.infrastructure.grpc.geo.GetGeolocationRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new app.delivery.infrastructure.grpc.geo.GetGeolocationRequest();
  }

  public static app.delivery.infrastructure.grpc.geo.GetGeolocationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetGeolocationRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetGeolocationRequest>() {
    @java.lang.Override
    public GetGeolocationRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<GetGeolocationRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetGeolocationRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public app.delivery.infrastructure.grpc.geo.GetGeolocationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

