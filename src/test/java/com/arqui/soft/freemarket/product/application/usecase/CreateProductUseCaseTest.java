package com.arqui.soft.freemarket.product.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.product.infrastructure.adapters.in.request.CreateProductRequest;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.product.infrastructure.adapters.in.request.CreateProductRequestFixture;
import com.arqui.soft.freemarket.product.domain.ports.out.CreateProductAdapter;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.out.SellerEntityFixture;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
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
class CreateProductUseCaseTest {

    @Mock
    private CreateProductAdapter createProductAdapter;

    @Mock
    private GetSellerAdapter getSellerAdapter;

    private CreateProductUseCase useCase;
    private CreateProductRequest request;
    @BeforeEach
    void setUp(){
        useCase = new CreateProductUseCase(createProductAdapter, getSellerAdapter);
    }

    @Test
    void whenCreateProductAndSellerDoestNotExistThrowException(){
        request = CreateProductRequestFixture.withDefaults();
        var exception = assertThrows(SellerDoesNotExistException.class, ()->
                useCase.create(request, request.getSellerId()));

        assertNotNull(exception);
        assertEquals(String.format("El vendedor con id %s no existe.", request.getSellerId()), exception.getMessage());
    }

    @Test
    void whenCreateProductAndSellerExistThenProductIsCreated() throws SellerDoesNotExistException {
        request = CreateProductRequestFixture.withDefaults();

        when(getSellerAdapter.getById(anyString()))
                .thenReturn(Optional.of(SellerEntityFixture.withDefaults()));

        when(createProductAdapter.create(any(ProductEntity.class)))
                .thenReturn(ProductEntity.builder()
                        .id(UUID.randomUUID().toString())
                        .stock(request.getStock())
                        .build());

        var product = useCase.create(request, request.getSellerId());

        assertNotNull(product);
        assertNotNull(product.getId());
        assertEquals(request.getStock(), product.getStock());
    }

}
