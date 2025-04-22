package com.arqui.soft.freemarket.commons.exceptions;

public class ProductDoestNotExistException extends Exception {
    public ProductDoestNotExistException(String id) {
        super((String.format("El producto con id %s no existe.", id)));
    }
}
