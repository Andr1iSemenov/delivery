package app.delivery.api.adapters.contract.openapi.api;

import app.delivery.api.adapters.contract.openapi.model.Courier;
import app.delivery.api.adapters.contract.openapi.model.Error;
import app.delivery.api.adapters.contract.openapi.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ApiApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T20:55:22.906773+03:00[Europe/Kiev]")
public interface ApiApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/orders : Создать заказ
     * Позволяет создать заказ с целью тестирования
     *
     * @return Успешный ответ (status code 201)
     *         or Ошибка (status code 200)
     * @see ApiApi#createOrder
     */
    default ResponseEntity<Void> createOrder() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/couriers/ : Получить всех курьеров
     * Позволяет получить всех курьеров
     *
     * @return Успешный ответ (status code 200)
     *         or Ошибка (status code 200)
     * @see ApiApi#getCouriers
     */
    default ResponseEntity<List<Courier>> getCouriers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"name\" : \"name\", \"location\" : { \"x\" : 0, \"y\" : 6 }, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"name\" : \"name\", \"location\" : { \"x\" : 0, \"y\" : 6 }, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/orders/active : Получить все незавершенные заказы
     * Позволяет получить все незавершенные
     *
     * @return Успешный ответ (status code 200)
     *         or Ошибка (status code 200)
     * @see ApiApi#getOrders
     */
    default ResponseEntity<List<Order>> getOrders() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"location\" : { \"x\" : 0, \"y\" : 6 }, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"location\" : { \"x\" : 0, \"y\" : 6 }, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
