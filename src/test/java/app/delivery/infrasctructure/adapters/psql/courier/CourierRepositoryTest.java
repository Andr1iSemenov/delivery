package app.delivery.infrasctructure.adapters.psql.courier;

import app.delivery.configs.ContainersEnvironment;
import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.core.domain.courier.aggregate.Transport;
import app.delivery.core.ports.CourierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CourierRepositoryTest extends ContainersEnvironment {

    @Autowired
    CourierRepository courierRepository;

    @Test
    void testSaveCourier() {
        UUID courierId = UUID.randomUUID();
        Courier courier = Courier.create(courierId, "John Doe", Transport.CAR);

        Courier savedCourier = courierRepository.save(courier);

        assertAll(
                () -> assertNotNull(savedCourier),
                () -> assertEquals(courierId, savedCourier.getId())
        );
    }

    @Test
    void testUpdateCourier() {
        UUID courierId = UUID.randomUUID();
        Courier courier = Courier.create(courierId, "John Doe", Transport.CAR);

        courierRepository.save(courier);
        courier.startWorkDay();

        courierRepository.update(courier);
        Courier updatedCourier = courierRepository.findById(courierId);

        assertEquals(CourierStatus.READY, updatedCourier.getStatus());
    }

    @Test
    void testFindById() {
        UUID courierId = UUID.randomUUID();
        Courier courier = Courier.create(courierId, "John Doe", Transport.CAR);

        courierRepository.save(courier);
        Courier foundCourier = courierRepository.findById(courierId);

        assertAll(
                () -> assertNotNull(foundCourier),
                () -> assertEquals(courierId, foundCourier.getId())
        );
    }

    @Test
    void testFindByIdNotFound() {
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(JpaObjectRetrievalFailureException.class,
                () -> courierRepository.findById(id));
        assertEquals(EntityNotFoundException.class, exception.getCause().getClass());
    }

    @Test
    void testFindAllFreeCouriers() {
        Courier courier1 = Courier.create(UUID.randomUUID(), "John Doe", Transport.CAR);
        Courier courier2 = Courier.create(UUID.randomUUID(), "Jane Doe", Transport.SCOOTER);
        Courier courier3 = Courier.create(UUID.randomUUID(), "Jim Beam", Transport.PEDESTRIAN);

        courier1.startWorkDay();
        courier2.startWorkDay();

        courierRepository.save(courier1);
        courierRepository.save(courier2);
        courierRepository.save(courier3);

        List<Courier> freeCouriers = courierRepository.findAllFreeCouriers();

        assertAll(
                () -> assertEquals(2, freeCouriers.size()),
                () -> assertTrue(freeCouriers.stream().allMatch(courier -> CourierStatus.READY.equals(courier.getStatus())))
        );
    }
}
