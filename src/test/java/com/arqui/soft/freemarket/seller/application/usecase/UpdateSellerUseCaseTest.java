package com.arqui.soft.freemarket.seller.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.product.infrastructure.adapters.in.request.UpdateSellerRequestFixture;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import com.arqui.soft.freemarket.seller.domain.ports.out.UpdateSellerAdapter;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.in.request.UpdateSellerRequest;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.out.SellerEntity;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.out.SellerEntityFixture;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateSellerUseCaseTest {

    @Mock
    private UpdateSellerAdapter updateSellerAdapter;

    @Mock
    private GetSellerAdapter getSellerAdapter;

    private UpdateSellerUseCase useCase;
    private UpdateSellerRequest request;
    private String sellerId;

    @BeforeEach
    void setUp(){
        useCase = new UpdateSellerUseCase(updateSellerAdapter, getSellerAdapter);
        sellerId = UUID.randomUUID().toString();
    }

    @Test
    void whenUpdateSellerAndSellerDoestNotExistThrowSellerDoesNotExistException(){
        request = UpdateSellerRequestFixture.withDefaults();

        var exception = assertThrows(SellerDoesNotExistException.class, ()->
                useCase.update(sellerId, request));

        assertNotNull(exception);
        assertEquals(String.format("El vendedor con id %s no existe.", sellerId), exception.getMessage());
    }

    @Test
    void whenUpdateSellerWithStockAndPriceAndSellerExistThenSellerIsCreated() throws SellerDoesNotExistException {
        request = UpdateSellerRequestFixture.withDefaults();

        when(getSellerAdapter.getById(anyString()))
                .thenReturn(Optional.of(SellerEntityFixture.withDefaults()));

        when(updateSellerAdapter.update(any(SellerEntity.class)))
                .thenReturn(SellerEntityFixture.withDefaults());

        var seller = useCase.update(SellerEntityFixture.ID, request);

        assertNotNull(seller);
        assertNotNull(seller.getId());
        verify(getSellerAdapter).getById(anyString());
        verify(updateSellerAdapter).update(any(SellerEntity.class));
    }

    @Test
    void whenUpdateSellerWithValuesAndSellerExistThenSellerIsCreated() throws SellerDoesNotExistException {
        request = UpdateSellerRequestFixture.withoutName();

        when(getSellerAdapter.getById(anyString()))
                .thenReturn(Optional.of(SellerEntityFixture.withDefaults()));

        when(updateSellerAdapter.update(any(SellerEntity.class)))
                .thenReturn(SellerEntityFixture.withDefaults());

        var seller = useCase.update(SellerEntityFixture.ID, request);

        assertNotNull(seller);
        assertNotNull(seller.getId());
        verify(getSellerAdapter).getById(anyString());
        verify(updateSellerAdapter).update(any(SellerEntity.class));
    }

}
