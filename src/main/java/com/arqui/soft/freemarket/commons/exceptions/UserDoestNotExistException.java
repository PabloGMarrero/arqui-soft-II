package com.arqui.soft.freemarket.commons.exceptions;

public class UserDoestNotExistException extends Exception {
    public UserDoestNotExistException(String userId) {
        super(String.format("El usuario con id %s no existe.", userId));
    }
}
