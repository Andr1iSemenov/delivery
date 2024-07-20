package app.delivery.api.adapters.http;

import app.delivery.api.adapters.contract.openapi.api.OrdersApi;
import app.delivery.api.adapters.contract.openapi.model.Order;
import app.delivery.api.adapters.converters.ModelOrderConverter;
import app.delivery.core.application.commands.orders.create.CreateOrderCommand;
import app.delivery.core.application.commands.orders.create.CreateOrderHandler;
import app.delivery.core.application.queries.orders.GetUncompletedOrdersQueryHandler;
import app.delivery.core.shared.kernel.Weight;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class OrderController implements OrdersApi {

    private final CreateOrderHandler createOrderHandler;
    private final GetUncompletedOrdersQueryHandler getUncompletedOrdersQueryHandler;
    private final ModelOrderConverter modelOrderConverter;


    @Override
    public ResponseEntity<Void> createOrder() {
        CreateOrderCommand createOrderCommand = new CreateOrderCommand(UUID.randomUUID(), "Несуществующая", new Weight(5));
        createOrderHandler.handle(createOrderCommand);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(modelOrderConverter.convert(getUncompletedOrdersQueryHandler.handle()), HttpStatus.OK);
    }
}
