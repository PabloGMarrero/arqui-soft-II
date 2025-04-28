package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.product.application.usecase.CreateProductUseCase;
import com.arqui.soft.freemarket.product.domain.ports.out.CreateProductAdapter;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

    @Mock
    private CreateProductAdapter createProductAdapter;

    @Mock
    private GetSellerAdapter getSellerAdapter;

    private CreateProductUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new CreateProductUseCase(createProductAdapter, getSellerAdapter);
    }

    //@Test
}
