package com.arqui.soft.freemarket.seller.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.seller.domain.ports.out.CreateSellerAdapter;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.in.request.CreateSellerRequest;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.in.request.CreateSellerRequestFixture;
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
class CreateSellerUseCaseTest {

    @Mock
    private CreateSellerAdapter createSellerAdapter;

    @Mock
    private GetSellerAdapter getSellerAdapter;

    private CreateSellerUseCase useCase;
    private CreateSellerRequest request;
    @BeforeEach
    void setUp(){
        useCase = new CreateSellerUseCase(createSellerAdapter, getSellerAdapter);
    }

    @Test
    void whenCreateSellerHasInvalidEmailThenRaiseInvalidEmailException(){
        request = CreateSellerRequestFixture.withWrongEmail();
        var exception = assertThrows(InvalidEmailException.class, ()-> useCase.create(request));

        assertNotNull(exception);
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void whenCreateSellerAndEmailAlReadyExistThenRaiseEmailAlreadyExistException(){
        request = CreateSellerRequestFixture.withDefaults();

        when(getSellerAdapter.getByEmail(anyString()))
                .thenReturn(Optional.of(SellerEntityFixture.withDefaults()));

        var exception = assertThrows(EmailAlreadyExistException.class, ()-> useCase.create(request));

        assertNotNull(exception);
        assertEquals("Email ya existente.", exception.getMessage());
        verify(getSellerAdapter).getByEmail(anyString());
    }

    @Test
    void whenCreateProductAndSellerExistThenProductIsCreated() throws InvalidEmailException, EmailAlreadyExistException {
        request = CreateSellerRequestFixture.withDefaults();

        when(getSellerAdapter.getByEmail(anyString()))
                .thenReturn(Optional.empty());

        when(createSellerAdapter.create(any(SellerEntity.class)))
                .thenReturn(SellerEntity.builder()
                        .id(UUID.randomUUID().toString())
                        .build());

        var seller = useCase.create(request);

        assertNotNull(seller);
        assertNotNull(seller.getId());
        verify(getSellerAdapter).getByEmail(anyString());
        verify(createSellerAdapter).create(any(SellerEntity.class));
    }

}
