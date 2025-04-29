package com.arqui.soft.freemarket.product.application.usecase;

import com.arqui.soft.freemarket.product.application.usecase.DeleteProductUseCase;
import com.arqui.soft.freemarket.product.domain.ports.out.DeleteProductAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteProductUseCaseTest {


    @Mock
    private DeleteProductAdapter deleteProductAdapter;

    private DeleteProductUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new DeleteProductUseCase(deleteProductAdapter);
    }


    @Test
    void whenDeleteProductVerifyAdapterIsCalled() {

        useCase.delete(UUID.randomUUID().toString());

        verify(deleteProductAdapter).delete(anyString());
    }

}
