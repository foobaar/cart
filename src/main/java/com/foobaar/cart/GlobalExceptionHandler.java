package com.foobaar.cart;

import com.foobaar.cart.exceptions.AppError;
import com.foobaar.cart.exceptions.CartNotFoundException;
import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

import static com.foobaar.cart.exceptions.AppErrorCodes.CART_NOT_FOUND;
import static com.foobaar.cart.exceptions.AppErrorCodes.UNEXPECTED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<Object> handleInternalServerError(final RuntimeException ex,
                                                               final WebRequest request) {
        String bodyOfResponse = "Oops...Something went terribly wrong..";
        String uuid = UUID.randomUUID().toString();
        AppError error =  new AppError(INTERNAL_SERVER_ERROR.value(), bodyOfResponse, UNEXPECTED.name(), uuid);
        log.error("errorId: {}", uuid, ex);
        return handleExceptionInternal(ex, error,
                new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = { ApplicationException.class})
    protected ResponseEntity<Object> handleApplicationException(final ApplicationException ex,
                                                               final WebRequest request) {
        String bodyOfResponse = "Oops...Something went terribly wrong..";
        String uuid = UUID.randomUUID().toString();
        AppError error =  new AppError(INTERNAL_SERVER_ERROR.value(), bodyOfResponse, UNEXPECTED.name(), uuid);
        log.error("errorId: {}", uuid, ex);
        return handleExceptionInternal(ex, error,
                new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = { CartNotFoundException.class})
    protected ResponseEntity<Object> handleCartNotFoundException(final CartNotFoundException ex,
                                                                final WebRequest request) {
        String bodyOfResponse = "Cart Not found for userId:" + ex.getMessage();
        String uuid = UUID.randomUUID().toString();
        AppError error =  new AppError(NOT_FOUND.value(), bodyOfResponse, CART_NOT_FOUND.name(), uuid);
        log.error("errorId: {} appErrorCode: {}", uuid, CART_NOT_FOUND.name());
        return handleExceptionInternal(ex, error,
                new HttpHeaders(), NOT_FOUND, request);
    }
}
