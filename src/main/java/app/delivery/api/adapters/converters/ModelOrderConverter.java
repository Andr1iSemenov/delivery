package app.delivery.api.adapters.converters;

import app.delivery.api.adapters.contract.openapi.model.Location;
import app.delivery.api.adapters.contract.openapi.model.Order;
import app.delivery.core.application.queries.orders.GetUncompletedOrdersResponse;
import org.springframework.stereotype.Service;

@Service
public class ModelOrderConverter {

    public Order convert(GetUncompletedOrdersResponse uncompletedOrdersResponse) {
        return new Order(uncompletedOrdersResponse.uuid(), new Location(uncompletedOrdersResponse.location().xCoordinate(), uncompletedOrdersResponse.location().yCoordinate()));
    }
}
