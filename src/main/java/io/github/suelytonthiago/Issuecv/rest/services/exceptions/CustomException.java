package io.github.suelytonthiago.Issuecv.rest.services.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends BaseBusinessException{

    public CustomException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
