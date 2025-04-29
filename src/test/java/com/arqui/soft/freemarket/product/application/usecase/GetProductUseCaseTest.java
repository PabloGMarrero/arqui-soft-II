package com.arqui.soft.freemarket.product.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.FilterIsNotAllowedException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductMapperAdapter;
import com.arqui.soft.freemarket.product.domain.config.ProductFilterStrategyConfiguration;
import com.arqui.soft.freemarket.product.domain.model.filter.BetweenFilter;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetProductUseCaseTest {

    @Mock
    private GetProductAdapter getProductAdapter;

    @Mock
    private ProductFilterStrategyConfiguration productFilterStrategy;

    @Mock
    private ProductMapperAdapter productMapperAdapter;

    private GetProductUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new GetProductUseCase(getProductAdapter, productFilterStrategy, productMapperAdapter);

    }

    @Test
    void getProductByName(){
        var result = useCase.getProductByName("NAME");

        assertNotNull(result);
        verify(getProductAdapter).getProductByName(anyString());
        verify(productMapperAdapter).mapProductsToModel(anyList());
    }

    @Test
    void getProductByCategory(){
        var result = useCase.getProductByCategory("CAT");

        assertNotNull(result);
        verify(getProductAdapter).getProductByCategory(anyString());
        verify(productMapperAdapter).mapProductsToModel(anyList());
    }

    @Test
    void whenGetProductWithFilterAndTypeIsNotValidThenRaiseFilterIsNotAllowedException() {

        when(productFilterStrategy.getStrategy(anyString())).thenReturn(null);

        var exception = assertThrows(FilterIsNotAllowedException.class, () ->
                useCase.filter("S", BigDecimal.ONE, BigDecimal.TWO, BigDecimal.ZERO));


        assertNotNull(exception);
        assertEquals(String.format("El filtro utilizado %s no es correcto, debe ser uno del listado en la documentación", "S"), exception.getMessage());

    }

    @Test
    void whenGetProductWithFilterAndTypeIsValidThenVerifyFilterIsCalled() throws InvalidFilterParameter, FilterIsNotAllowedException {
        var filter = mock(BetweenFilter.class);
        when(productFilterStrategy.getStrategy(anyString())).thenReturn(filter);

        var products = useCase.filter("S", BigDecimal.ONE, BigDecimal.TWO, BigDecimal.ZERO);

        assertNotNull(products);
        verify(filter).filter(any(BigDecimal.class),any(BigDecimal.class),any(BigDecimal.class));
    }
}
