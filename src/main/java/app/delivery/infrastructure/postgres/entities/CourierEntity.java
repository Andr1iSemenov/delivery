package app.delivery.infrastructure.postgres.entities;

import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.core.domain.courier.aggregate.Transport;
import app.delivery.core.shared.kernel.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "courier")
public class CourierEntity {

    @Id
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Transport transport;

    @Embedded
    private Location location;

    @Enumerated(EnumType.STRING)
    private CourierStatus status;
}
