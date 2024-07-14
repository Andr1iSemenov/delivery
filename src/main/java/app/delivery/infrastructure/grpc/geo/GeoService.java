package app.delivery.infrastructure.grpc.geo;

import app.delivery.core.shared.kernel.Location;
import app.delivery.infrastructure.grpc.geo.gen.GeoGrpc;
import app.delivery.infrastructure.grpc.geo.gen.GetGeolocationReply;
import app.delivery.infrastructure.grpc.geo.gen.GetGeolocationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeoService {

    private final GeoGrpc.GeoBlockingStub geoBlockingStub;


    public Location getLocation(String street) {
        GetGeolocationRequest request = GetGeolocationRequest.newBuilder()
                .setStreet(street)
                .build();

        GetGeolocationReply response = geoBlockingStub.getGeolocation(request);
        log.info("Geo location response: {}", response);
        return new Location(response.getLocation().getX(), response.getLocation().getY());
    }
}
