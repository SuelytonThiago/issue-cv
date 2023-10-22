package io.github.suelytonthiago.Issuecv.rest.controllers.exception;

import io.github.suelytonthiago.Issuecv.rest.services.exceptions.BaseBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseBusinessException.class)
    public ProblemDetail baseBusiness(BaseBusinessException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(e.getStatusCode());
        problemDetail.setProperty("TimeStamp", LocalDate.now());
        problemDetail.setProperty("Message",e.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValid(MethodArgumentNotValidException e){
        List<String> error = e.getBindingResult().getAllErrors().stream()
                .map(er -> er.getDefaultMessage()).collect(Collectors.toList());
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setProperty("TimeStamp",LocalDate.now());
        problemDetail.setProperty("Message",error);
        return problemDetail;
    }
}
