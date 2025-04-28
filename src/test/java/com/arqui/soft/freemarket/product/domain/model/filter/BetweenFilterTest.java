package com.arqui.soft.freemarket.product.domain.model.filter;

import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductMapperAdapter;
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
class BetweenFilterTest {
    public static final String EXPECTED = "El filtro de busqueda entre debe tener los parámetros minPrice y maxPrice";
    @Mock
    private GetProductAdapter getProductAdapter;

    @Mock
    private ProductMapperAdapter productMapperAdapter;

    private BetweenFilter filter;

    @BeforeEach
    void setUp(){
        filter = new BetweenFilter(getProductAdapter, productMapperAdapter);
    }

    @Test
    void whenFilterAndMinPriceIsNullThenRaiseInvalidFilterParameter(){
        var exception = assertThrows(InvalidFilterParameter.class,
                ()-> filter.filter(null, null, null)
        );

        assertEquals(EXPECTED, exception.getMessage());
    }

    @Test
    void whenFilterAndMaxPriceIsNullThenRaiseInvalidFilterParameter(){
        var exception = assertThrows(InvalidFilterParameter.class,
                ()-> filter.filter(BigDecimal.ONE, null, null)
        );

        assertEquals(EXPECTED, exception.getMessage());
    }

    @Test
    void whenFilterAndGetProductReturnEmptyListThenResultIsEmpty() throws InvalidFilterParameter {
        var products = filter.filter(BigDecimal.ONE, BigDecimal.TWO, null);

        assertTrue(products.isEmpty());
    }

    @Test
    void whenFilterAndGetProductReturnOneElementThenResultIsNotEmpty() throws InvalidFilterParameter {
        when(productMapperAdapter.mapProductsToModel(any()))
                .thenReturn(Collections.singletonList(Product.builder()
                        .stock(10)
                        .name("producto")
                        .build()));
        var products = filter.filter(BigDecimal.ONE, BigDecimal.TWO, null);

        assertFalse(products.isEmpty());
        assertEquals(10, products.getFirst().getStock());
    }

}
