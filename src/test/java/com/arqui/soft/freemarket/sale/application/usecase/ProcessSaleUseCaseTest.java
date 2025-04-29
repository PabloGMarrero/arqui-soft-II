package com.arqui.soft.freemarket.sale.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.ProcessSaleException;
import com.arqui.soft.freemarket.commons.exceptions.ProductDoestNotExistException;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntityFixture;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import com.arqui.soft.freemarket.product.domain.ports.out.UpdateProductAdapter;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.sale.infrastructure.adapters.in.request.SaleRequestFixture;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.out.SellerEntityFixture;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProcessSaleUseCaseTest {

    @Mock
    private GetProductAdapter getProductAdapter;

    @Mock
    private GetSellerAdapter getSellerAdapter;

    @Mock
    private UpdateProductAdapter updateProductAdapter;
    
    private ProcessSaleUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new ProcessSaleUseCase(getProductAdapter, getSellerAdapter, updateProductAdapter);
    }

    @Test
    void whenProcessSaleAndProductDoesNotExistThenRaiseProductDoestNotExistException(){
        var exception = assertThrows(ProductDoestNotExistException.class, () ->
                useCase.process(SaleRequestFixture.withDefaults()));

        assertNotNull(exception);
        assertEquals(String.format("El producto con id %s no existe.", SaleRequestFixture.PRODUCT_ID), exception.getMessage());
        verify(getProductAdapter).getById(anyString());
    }

    @Test
    void whenProcessSaleAndSellerDoesNotExistThenRaiseSellerDoesNotExistException(){
        when(getProductAdapter.getById(anyString()))
                .thenReturn(Optional.of(ProductEntityFixture.withDefaults()));

        var exception = assertThrows(SellerDoesNotExistException.class, () ->
                useCase.process(SaleRequestFixture.withDefaults()));

        assertNotNull(exception);
        assertEquals(String.format("El vendedor con id %s no existe.", SaleRequestFixture.SELLER_ID), exception.getMessage());
        verify(getProductAdapter).getById(anyString());
    }

    @Test
    void whenProcessSaleAndProductDoestNotBelongToSellerThenRaiseProcessSaleException(){
        when(getProductAdapter.getById(anyString()))
                .thenReturn(Optional.of(ProductEntityFixture.withDefaults()));

        when(getSellerAdapter.getById(anyString()))
                .thenReturn(Optional.of(SellerEntityFixture.withDefaults()));

        var exception = assertThrows(ProcessSaleException.class, () ->
                useCase.process(SaleRequestFixture.withDefaults()));

        assertNotNull(exception);
        assertEquals(String.format("El producto con id %s no pertenece al vendedor con id %s.", ProductEntityFixture.ID, SellerEntityFixture.ID),
                exception.getMessage());
        verify(getProductAdapter).getById(anyString());
        verify(getSellerAdapter).getById(anyString());
    }

    @Test
    void whenProcessSaleAndProductBelongToSellerThenProcessSale() throws ProductDoestNotExistException, ProcessSaleException, SellerDoesNotExistException {
        when(getProductAdapter.getById(anyString()))
                .thenReturn(Optional.of(ProductEntityFixture.withSellerId()));

        when(getSellerAdapter.getById(anyString()))
                .thenReturn(Optional.of(SellerEntityFixture.withDefaults()));

        when(updateProductAdapter.update(any(ProductEntity.class)))
                .thenReturn(ProductEntityFixture.withDefaults());

        var sale = useCase.process(SaleRequestFixture.withDefaults());

        assertNotNull(sale);
        assertEquals(ProductEntityFixture.ID, sale.getProductId());
        assertEquals(SellerEntityFixture.ID, sale.getSellerId());
        verify(updateProductAdapter).update(any(ProductEntity.class));
    }
}
