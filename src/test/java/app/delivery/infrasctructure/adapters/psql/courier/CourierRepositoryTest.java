package app.delivery.infrasctructure.adapters.psql.courier;

import app.delivery.configs.ContainersEnvironment;
import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.core.domain.courier.aggregate.Transport;
import app.delivery.core.ports.CourierRepository;
import app.delivery.utils.JsonFileReader;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CourierRepositoryTest extends ContainersEnvironment {

    private static final UUID COURIER_ID = UUID.fromString("11111111-1111-1111-1111-111111111111");

    @Autowired
    CourierRepository courierRepository;


    @Test
    void saveCourier() {
        UUID courierId = UUID.randomUUID();
        Courier courier = Courier.create(courierId, "John Doe", Transport.CAR);

        Courier savedCourier = courierRepository.save(courier);

        assertAll(
                () -> assertNotNull(savedCourier),
                () -> assertEquals(courierId, savedCourier.getId())
        );
    }

    @Test
    @Sql({
            "/files/infrastructure/adapters/postgres/courier/sql/00_truncate.sql",
            "/files/infrastructure/adapters/postgres/courier/sql/01_insert_courier_READY.sql"
    })
    void updateCourier() throws IOException {
        Courier courier = JsonFileReader.readFromFile("/files/core/domain/courier/aggregate/courier_NOT_AVAILABLE.json", Courier.class);

        assertDoesNotThrow(() -> courierRepository.update(courier));
    }

    @Test
    @Sql({
            "/files/infrastructure/adapters/postgres/courier/sql/00_truncate.sql",
            "/files/infrastructure/adapters/postgres/courier/sql/01_insert_courier_READY.sql"
    })
    void findById() {
        Courier foundCourier = courierRepository.findById(COURIER_ID);

        assertAll(
                () -> assertNotNull(foundCourier),
                () -> assertEquals(COURIER_ID, foundCourier.getId())
        );
    }

    @Test
    void findByIdNotFound() {
        UUID id = UUID.randomUUID();

        Throwable exception = assertThrows(JpaObjectRetrievalFailureException.class,
                () -> courierRepository.findById(id));
        assertEquals(EntityNotFoundException.class, exception.getCause().getClass());
    }

    @Test
    @Sql({
            "/files/infrastructure/adapters/postgres/courier/sql/00_truncate.sql",
            "/files/infrastructure/adapters/postgres/courier/sql/01_insert_courier_READY.sql",
            "/files/infrastructure/adapters/postgres/courier/sql/02_insert_courier_NOT_AVAILABLE.sql",
            "/files/infrastructure/adapters/postgres/courier/sql/03_insert_courier_BUSY.sql"
    })
    void findAllFreeCouriers() {
        List<Courier> freeCouriers = courierRepository.findAllFreeCouriers();

        assertAll(
                () -> assertEquals(1, freeCouriers.size()),
                () -> assertTrue(freeCouriers.stream().allMatch(courier -> CourierStatus.READY.equals(courier.getStatus())))
        );
    }
}
