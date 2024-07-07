package app.delivery.api.adapters.contract.openapi.api;

import app.delivery.api.adapters.contract.openapi.model.Courier;
import app.delivery.api.adapters.contract.openapi.model.Error;
import app.delivery.api.adapters.contract.openapi.model.Order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T20:55:22.906773+03:00[Europe/Kiev]")
@Controller
@RequestMapping("${openapi.swaggerDelivery.base-path:}")
public class ApiApiController implements ApiApi {

    private final ApiApiDelegate delegate;

    public ApiApiController(@Autowired(required = false) ApiApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ApiApiDelegate() {});
    }

    @Override
    public ApiApiDelegate getDelegate() {
        return delegate;
    }

}
