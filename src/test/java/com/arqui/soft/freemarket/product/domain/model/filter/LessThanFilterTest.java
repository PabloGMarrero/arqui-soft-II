package com.arqui.soft.freemarket.product.domain.model.filter;

import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductMapperAdapter;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LessThanFilterTest {
    public static final String EXPECTED = "El filtro de busqueda menor que debe tener el parámetro price";
    @Mock
    private GetProductAdapter getProductAdapter;

    @Mock
    private ProductMapperAdapter productMapperAdapter;

    private LessThanFilter filter;

    @BeforeEach
    void setUp(){
        filter = new LessThanFilter(getProductAdapter, productMapperAdapter);
    }

    @Test
    void whenFilterAndPriceIsNullThenRaiseInvalidFilterParameter(){
        var exception = assertThrows(InvalidFilterParameter.class,
                ()-> filter.filter(null, null, null)
        );

        assertEquals(EXPECTED, exception.getMessage());
    }


    @Test
    void whenFilterAndGetProductReturnEmptyListThenResultIsEmpty() throws InvalidFilterParameter {
        var products = filter.filter(null, null, BigDecimal.ONE);

        assertTrue(products.isEmpty());
    }

    @Test
    void whenFilterAndGetProductReturnOneElementThenResultIsNotEmpty() throws InvalidFilterParameter {
        when(productMapperAdapter.mapProductsToModel(any()))
                .thenReturn(Collections.singletonList(Product.builder()
                        .stock(10)
                        .name("producto")
                        .build()));

        var products = filter.filter(null, null, BigDecimal.ONE);

        assertFalse(products.isEmpty());
        assertEquals(10, products.getFirst().getStock());
    }

}
