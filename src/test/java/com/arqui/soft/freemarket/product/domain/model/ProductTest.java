package com.arqui.soft.freemarket.product.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProductTest {

    @Test
    void validateRemoveStockWhenStockIs1(){
        var product = Product.builder()
                .stock(1)
                .build();
        product.removeStock(1);

        assertEquals(0, product.getStock());
    }

    @Test
    void validateRemoveStockWhenStockIs0ThenRaiseIllegalArgumentException(){
        var product = Product.builder()
                .stock(0)
                .build();

        var exception = assertThrows(IllegalArgumentException.class,
                ()-> product.removeStock(1)
        );

        assertEquals("Stock insuficiente", exception.getMessage());
    }

    @Test
    void validateRemoveStock11WhenStockIs10ThenRaiseIllegalArgumentException(){
        var product = Product.builder()
                .stock(10)
                .build();

        var exception = assertThrows(IllegalArgumentException.class,
                ()-> product.removeStock(11)
        );

        assertEquals("Stock insuficiente", exception.getMessage());
    }
}
