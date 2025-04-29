package com.arqui.soft.freemarket.product.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.ProductDoestNotExistException;
import com.arqui.soft.freemarket.product.infrastructure.adapters.in.request.UpdateProductRequest;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.product.infrastructure.adapters.in.request.UpdateProductRequestFixture;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntityFixture;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import com.arqui.soft.freemarket.product.domain.ports.out.UpdateProductAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateProductUseCaseTest {

    @Mock
    private UpdateProductAdapter updateProductAdapter;

    @Mock
    private GetProductAdapter getProductAdapter;

    private UpdateProductUseCase useCase;
    private UpdateProductRequest request;
    private String productId;

    @BeforeEach
    void setUp(){
        useCase = new UpdateProductUseCase(updateProductAdapter, getProductAdapter);
        productId = UUID.randomUUID().toString();
    }

    @Test
    void whenUpdateProductAndProductDoestNotExistThrowProductDoestNotExistException(){
        request = UpdateProductRequestFixture.withStockAndPrice();

        var exception = assertThrows(ProductDoestNotExistException.class, ()->
                useCase.update(productId, request));

        assertNotNull(exception);
        assertEquals(String.format("El producto con id %s no existe.", productId), exception.getMessage());
    }

    @Test
    void whenUpdateProductWithStockAndPriceAndProductExistThenProductIsCreated() throws ProductDoestNotExistException {
        request = UpdateProductRequestFixture.withStockAndPrice();

        when(getProductAdapter.getById(anyString()))
                .thenReturn(Optional.of(ProductEntityFixture.withDefaults()));

        when(updateProductAdapter.update(any(ProductEntity.class)))
                .thenReturn(ProductEntityFixture.withDefaults());

        var product = useCase.update(ProductEntityFixture.ID, request);

        assertNotNull(product);
        assertNotNull(product.getId());
        assertEquals(request.getStock(), product.getStock());
    }

    @Test
    void whenUpdateProductWithValuesAndProductExistThenProductIsCreated() throws ProductDoestNotExistException {
        request = UpdateProductRequestFixture.withDefaults();

        when(getProductAdapter.getById(anyString()))
                .thenReturn(Optional.of(ProductEntityFixture.withDefaults()));

        when(updateProductAdapter.update(any(ProductEntity.class)))
                .thenReturn(ProductEntityFixture.withDefaults());

        var product = useCase.update(ProductEntityFixture.ID, request);

        assertNotNull(product);
        assertNotNull(product.getId());
        assertEquals(request.getStock(), product.getStock());
    }

}
