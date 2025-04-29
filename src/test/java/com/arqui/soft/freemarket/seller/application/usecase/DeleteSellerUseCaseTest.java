package com.arqui.soft.freemarket.seller.application.usecase;

import com.arqui.soft.freemarket.seller.domain.ports.out.DeleteSellerAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteSellerUseCaseTest {


    @Mock
    private DeleteSellerAdapter deleteSellerAdapter;

    private DeleteSellerUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new DeleteSellerUseCase(deleteSellerAdapter);
    }


    @Test
    void whenDeleteSellerVerifyAdapterIsCalled() {

        useCase.delete(UUID.randomUUID().toString());

        verify(deleteSellerAdapter).delete(anyString());
    }

}
