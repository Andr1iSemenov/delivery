package app.delivery.core.application.queries.couriers;

import app.delivery.core.domain.courier.aggregate.Transport;
import app.delivery.core.shared.kernel.Location;

import java.util.UUID;

public record GetBusyCouriersResponse(UUID id, String name, Location location, Transport transport) {
}
