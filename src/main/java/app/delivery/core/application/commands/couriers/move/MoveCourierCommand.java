package app.delivery.core.application.commands.couriers.move;

import lombok.NonNull;

import java.util.UUID;

public record MoveCourierCommand(@NonNull UUID courierId) {}
