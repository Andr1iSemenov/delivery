package app.delivery.core.domain.domain_events;

import app.delivery.core.domain.order.aggregate.OrderStatus;
import lombok.NonNull;

import java.util.UUID;

public record OrderStatusChangedEvent(@NonNull UUID orderId, @NonNull OrderStatus orderStatus) {}
