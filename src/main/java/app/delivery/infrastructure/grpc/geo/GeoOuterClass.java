// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: Geo.proto
// Protobuf Java Version: 4.27.2

package app.delivery.infrastructure.grpc.geo;

public final class GeoOuterClass {
  private GeoOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      GeoOuterClass.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_app_delivery_infrastructure_grpc_geo_Location_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_app_delivery_infrastructure_grpc_geo_Location_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_app_delivery_infrastructure_grpc_geo_ErrorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_app_delivery_infrastructure_grpc_geo_ErrorResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tGeo.proto\022$app.delivery.infrastructure" +
      ".grpc.geo\"\'\n\025GetGeolocationRequest\022\016\n\006St" +
      "reet\030\001 \001(\t\"W\n\023GetGeolocationReply\022@\n\010Loc" +
      "ation\030\001 \001(\0132..app.delivery.infrastructur" +
      "e.grpc.geo.Location\" \n\010Location\022\t\n\001x\030\001 \001" +
      "(\005\022\t\n\001y\030\002 \001(\005\"\035\n\rErrorResponse\022\014\n\004text\030\001" +
      " \001(\t2\220\001\n\003Geo\022\210\001\n\016GetGeolocation\022;.app.de" +
      "livery.infrastructure.grpc.geo.GetGeoloc" +
      "ationRequest\0329.app.delivery.infrastructu" +
      "re.grpc.geo.GetGeolocationReplyB\002P\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationRequest_descriptor,
        new java.lang.String[] { "Street", });
    internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_app_delivery_infrastructure_grpc_geo_GetGeolocationReply_descriptor,
        new java.lang.String[] { "Location", });
    internal_static_app_delivery_infrastructure_grpc_geo_Location_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_app_delivery_infrastructure_grpc_geo_Location_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_app_delivery_infrastructure_grpc_geo_Location_descriptor,
        new java.lang.String[] { "X", "Y", });
    internal_static_app_delivery_infrastructure_grpc_geo_ErrorResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_app_delivery_infrastructure_grpc_geo_ErrorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_app_delivery_infrastructure_grpc_geo_ErrorResponse_descriptor,
        new java.lang.String[] { "Text", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
