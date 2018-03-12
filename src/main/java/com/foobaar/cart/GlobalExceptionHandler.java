package com.foobaar.cart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<Object> handleInternalServerError(final RuntimeException ex,
                                                               final WebRequest request) {
        String bodyOfResponse = "Oops...Something went terribly wrong..";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }
}
