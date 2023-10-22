package io.github.suelytonthiago.Issuecv.rest.services.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends BaseBusinessException{

    public ObjectNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
