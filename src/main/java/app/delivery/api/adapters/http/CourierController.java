package app.delivery.api.adapters.http;

import app.delivery.api.adapters.contract.openapi.api.CouriersApi;
import app.delivery.api.adapters.contract.openapi.model.Courier;
import app.delivery.api.adapters.converters.ModelCourierConverter;
import app.delivery.core.ports.CourierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CourierController implements CouriersApi {

    private final CourierRepository courierRepository;
    private final ModelCourierConverter modelCourierConverter;


    @Override
    public ResponseEntity<List<Courier>> getCouriers() {
        return new ResponseEntity<>(courierRepository.findAllCouriers().stream().map(modelCourierConverter::convert).toList(), HttpStatus.OK);
    }
}
