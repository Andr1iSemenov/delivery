package app.delivery.core.application.queries.orders;

import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;

import java.util.UUID;

public record GetUncompletedOrdersResponse(UUID uuid, UUID courierId, OrderStatus status, Weight weight, Location location) {}