package app.delivery.infrastructure.grpc.configuration;

import app.delivery.infrastructure.grpc.geo.gen.GeoGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfiguration {

    @Value("${delivery.geo.ip}")
    private String geoIP;

    @Value("${delivery.geo.port}")
    private int port;


    @Bean
    public ManagedChannel managedChannel() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        return ManagedChannelBuilder.forAddress(geoIP, port)
                .usePlaintext() // Use plaintext communication (no TLS)
                .build();
    }

    @Bean
    public GeoGrpc.GeoBlockingStub geoBlockingStub(ManagedChannel managedChannel) {
        return GeoGrpc.newBlockingStub(managedChannel);
    }
}
