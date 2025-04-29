package com.arqui.soft.freemarket.commons.exceptions;

public class UserDoesNotExistException extends Exception {
    public UserDoesNotExistException(String userId) {
        super(String.format("El usuario con id %s no existe.", userId));
    }
}
