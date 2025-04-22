package com.arqui.soft.freemarket.commons.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidEmailException.class)
    protected ResponseEntity<Object> handleInvalidEmailException(InvalidEmailException ex) {
        return buildResponseEntity(new ResponseUnit(ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    protected ResponseEntity<Object> handleCreateUserException(EmailAlreadyExistException ex) {
        return buildResponseEntity(new ResponseUnit(ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SellerDoesNotExistException.class)
    protected ResponseEntity<Object> handleSellerDoesNotExistException(SellerDoesNotExistException ex) {
        return buildResponseEntity(new ResponseUnit(ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductDoestNotExistException.class)
    protected ResponseEntity<Object> handleProductDoestNotExistException(ProductDoestNotExistException ex) {
        return buildResponseEntity(new ResponseUnit(ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProcessSaleException.class)
    protected ResponseEntity<Object> handleProcessSaleException(ProcessSaleException ex) {
        return buildResponseEntity(new ResponseUnit(ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FilterIsNotAllowedException.class)
    protected ResponseEntity<Object> handleFilterIsNotAllowedException(FilterIsNotAllowedException ex) {
        return buildResponseEntity(new ResponseUnit(ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFilterParameter.class)
    protected ResponseEntity<Object> handleInvalidFilterParameter(InvalidFilterParameter ex) {
        return buildResponseEntity(new ResponseUnit(ex.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildResponseEntity(ResponseUnit response, HttpStatus statusCode) {
        return new ResponseEntity<>(response, statusCode);
    }
}
