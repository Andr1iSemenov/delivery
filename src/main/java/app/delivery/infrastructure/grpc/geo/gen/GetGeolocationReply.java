// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: Geo.proto
// Protobuf Java Version: 4.27.2

package app.delivery.infrastructure.grpc.geo.gen;

/**
 * <pre>
 * Response
 * </pre>
 *
 * Protobuf type {@code GetGeolocationReply}
 */
public final class GetGeolocationReply extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:GetGeolocationReply)
    GetGeolocationReplyOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      GetGeolocationReply.class.getName());
  }
  // Use GetGeolocationReply.newBuilder() to construct.
  private GetGeolocationReply(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GetGeolocationReply() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return app.delivery.infrastructure.grpc.geo.gen.GeoOuterClass.internal_static_GetGeolocationReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return app.delivery.infrastructure.grpc.geo.gen.GeoOuterClass.internal_static_GetGeolocationReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply.class, app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply.Builder.class);
  }

  private int bitField0_;
  public static final int LOCATION_FIELD_NUMBER = 1;
  private app.delivery.infrastructure.grpc.geo.gen.Location location_;
  /**
   * <code>.Location Location = 1;</code>
   * @return Whether the location field is set.
   */
  @java.lang.Override
  public boolean hasLocation() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.Location Location = 1;</code>
   * @return The location.
   */
  @java.lang.Override
  public app.delivery.infrastructure.grpc.geo.gen.Location getLocation() {
    return location_ == null ? app.delivery.infrastructure.grpc.geo.gen.Location.getDefaultInstance() : location_;
  }
  /**
   * <code>.Location Location = 1;</code>
   */
  @java.lang.Override
  public app.delivery.infrastructure.grpc.geo.gen.LocationOrBuilder getLocationOrBuilder() {
    return location_ == null ? app.delivery.infrastructure.grpc.geo.gen.Location.getDefaultInstance() : location_;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getLocation());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLocation());
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
    if (!(obj instanceof app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply)) {
      return super.equals(obj);
    }
    app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply other = (app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply) obj;

    if (hasLocation() != other.hasLocation()) return false;
    if (hasLocation()) {
      if (!getLocation()
          .equals(other.getLocation())) return false;
    }
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
    if (hasLocation()) {
      hash = (37 * hash) + LOCATION_FIELD_NUMBER;
      hash = (53 * hash) + getLocation().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply parseFrom(
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
  public static Builder newBuilder(app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply prototype) {
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
   * Response
   * </pre>
   *
   * Protobuf type {@code GetGeolocationReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetGeolocationReply)
      app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return app.delivery.infrastructure.grpc.geo.gen.GeoOuterClass.internal_static_GetGeolocationReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return app.delivery.infrastructure.grpc.geo.gen.GeoOuterClass.internal_static_GetGeolocationReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply.class, app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply.Builder.class);
    }

    // Construct using app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getLocationFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      location_ = null;
      if (locationBuilder_ != null) {
        locationBuilder_.dispose();
        locationBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return app.delivery.infrastructure.grpc.geo.gen.GeoOuterClass.internal_static_GetGeolocationReply_descriptor;
    }

    @java.lang.Override
    public app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply getDefaultInstanceForType() {
      return app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply.getDefaultInstance();
    }

    @java.lang.Override
    public app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply build() {
      app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply buildPartial() {
      app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply result = new app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.location_ = locationBuilder_ == null
            ? location_
            : locationBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply) {
        return mergeFrom((app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply other) {
      if (other == app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply.getDefaultInstance()) return this;
      if (other.hasLocation()) {
        mergeLocation(other.getLocation());
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
              input.readMessage(
                  getLocationFieldBuilder().getBuilder(),
                  extensionRegistry);
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

    private app.delivery.infrastructure.grpc.geo.gen.Location location_;
    private com.google.protobuf.SingleFieldBuilder<
        app.delivery.infrastructure.grpc.geo.gen.Location, app.delivery.infrastructure.grpc.geo.gen.Location.Builder, app.delivery.infrastructure.grpc.geo.gen.LocationOrBuilder> locationBuilder_;
    /**
     * <code>.Location Location = 1;</code>
     * @return Whether the location field is set.
     */
    public boolean hasLocation() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.Location Location = 1;</code>
     * @return The location.
     */
    public app.delivery.infrastructure.grpc.geo.gen.Location getLocation() {
      if (locationBuilder_ == null) {
        return location_ == null ? app.delivery.infrastructure.grpc.geo.gen.Location.getDefaultInstance() : location_;
      } else {
        return locationBuilder_.getMessage();
      }
    }
    /**
     * <code>.Location Location = 1;</code>
     */
    public Builder setLocation(app.delivery.infrastructure.grpc.geo.gen.Location value) {
      if (locationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        location_ = value;
      } else {
        locationBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.Location Location = 1;</code>
     */
    public Builder setLocation(
        app.delivery.infrastructure.grpc.geo.gen.Location.Builder builderForValue) {
      if (locationBuilder_ == null) {
        location_ = builderForValue.build();
      } else {
        locationBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.Location Location = 1;</code>
     */
    public Builder mergeLocation(app.delivery.infrastructure.grpc.geo.gen.Location value) {
      if (locationBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          location_ != null &&
          location_ != app.delivery.infrastructure.grpc.geo.gen.Location.getDefaultInstance()) {
          getLocationBuilder().mergeFrom(value);
        } else {
          location_ = value;
        }
      } else {
        locationBuilder_.mergeFrom(value);
      }
      if (location_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.Location Location = 1;</code>
     */
    public Builder clearLocation() {
      bitField0_ = (bitField0_ & ~0x00000001);
      location_ = null;
      if (locationBuilder_ != null) {
        locationBuilder_.dispose();
        locationBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.Location Location = 1;</code>
     */
    public app.delivery.infrastructure.grpc.geo.gen.Location.Builder getLocationBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getLocationFieldBuilder().getBuilder();
    }
    /**
     * <code>.Location Location = 1;</code>
     */
    public app.delivery.infrastructure.grpc.geo.gen.LocationOrBuilder getLocationOrBuilder() {
      if (locationBuilder_ != null) {
        return locationBuilder_.getMessageOrBuilder();
      } else {
        return location_ == null ?
            app.delivery.infrastructure.grpc.geo.gen.Location.getDefaultInstance() : location_;
      }
    }
    /**
     * <code>.Location Location = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        app.delivery.infrastructure.grpc.geo.gen.Location, app.delivery.infrastructure.grpc.geo.gen.Location.Builder, app.delivery.infrastructure.grpc.geo.gen.LocationOrBuilder> 
        getLocationFieldBuilder() {
      if (locationBuilder_ == null) {
        locationBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            app.delivery.infrastructure.grpc.geo.gen.Location, app.delivery.infrastructure.grpc.geo.gen.Location.Builder, app.delivery.infrastructure.grpc.geo.gen.LocationOrBuilder>(
                getLocation(),
                getParentForChildren(),
                isClean());
        location_ = null;
      }
      return locationBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:GetGeolocationReply)
  }

  // @@protoc_insertion_point(class_scope:GetGeolocationReply)
  private static final app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply();
  }

  public static app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetGeolocationReply>
      PARSER = new com.google.protobuf.AbstractParser<GetGeolocationReply>() {
    @java.lang.Override
    public GetGeolocationReply parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetGeolocationReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetGeolocationReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

