package app.delivery.core.application.commands.orders.create;

import app.delivery.core.shared.kernel.Weight;
import lombok.NonNull;

import java.util.UUID;

public record CreateOrderCommand(@NonNull UUID basketId, @NonNull String address, @NonNull Weight weight) {

    public CreateOrderCommand {
        if (address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be blank");
        }
    }
}
