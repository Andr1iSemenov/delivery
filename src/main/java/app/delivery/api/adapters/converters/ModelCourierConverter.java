package app.delivery.api.adapters.converters;

import app.delivery.api.adapters.contract.openapi.model.Location;
import app.delivery.core.domain.courier.aggregate.Courier;
import org.springframework.stereotype.Component;

@Component
public class ModelCourierConverter {

    public app.delivery.api.adapters.contract.openapi.model.Courier convert(Courier courier) {
        Location location = new Location(courier.getLocation().xCoordinate(), courier.getLocation().yCoordinate());
        return new app.delivery.api.adapters.contract.openapi.model.Courier(courier.getId(), courier.getName(), location);
    }
}
