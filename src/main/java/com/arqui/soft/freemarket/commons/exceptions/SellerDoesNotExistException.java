package com.arqui.soft.freemarket.commons.exceptions;

public class SellerDoesNotExistException extends Exception {
    public SellerDoesNotExistException(String id) {
        super(String.format("El vendedor con id %s no existe.", id));
    }
}
