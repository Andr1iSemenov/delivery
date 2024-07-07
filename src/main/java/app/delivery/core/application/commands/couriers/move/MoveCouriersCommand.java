package app.delivery.core.application.commands.couriers.move;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.order.aggregate.Order;
import lombok.NonNull;

public record MoveCouriersCommand(@NonNull Order order, @NonNull Courier courier) {}
