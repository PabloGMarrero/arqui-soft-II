package com.arqui.soft.freemarket.sale.application.usecase;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.commons.exceptions.ProcessSaleException;
import com.arqui.soft.freemarket.commons.exceptions.ProductDoestNotExistException;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import com.arqui.soft.freemarket.product.domain.ports.out.UpdateProductAdapter;
import com.arqui.soft.freemarket.sale.infrastructure.adapters.in.request.SaleRequest;
import com.arqui.soft.freemarket.sale.infrastructure.adapters.in.response.SaleResponse;
import com.arqui.soft.freemarket.sale.domain.ports.in.ProcessSalePort;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import org.springframework.stereotype.Service;

@Service
public class ProcessSaleUseCase implements ProcessSalePort {
    private final GetProductAdapter getProductAdapter;
    private final GetSellerAdapter getSellerAdapter;
    private final UpdateProductAdapter updateProductAdapter;

    public ProcessSaleUseCase(GetProductAdapter getProductAdapter, GetSellerAdapter getSellerAdapter, UpdateProductAdapter updateProductAdapter) {
        this.getProductAdapter = getProductAdapter;
        this.getSellerAdapter = getSellerAdapter;
        this.updateProductAdapter = updateProductAdapter;
    }

    @Override
    public SaleResponse process(SaleRequest sale) throws ProductDoestNotExistException, SellerDoesNotExistException, ProcessSaleException {

        //validar si existe productId
        var optionalProduct = getProductAdapter.getById(sale.getProductId());
        if(optionalProduct.isEmpty()){
            throw new ProductDoestNotExistException(sale.getProductId());
        }

        //validar si existe sellerId
        var optionalSeller = getSellerAdapter.getById(sale.getSellerId());
        if(optionalSeller.isEmpty()){
            throw new SellerDoesNotExistException(sale.getSellerId());
        }

        //validar si sellerId pertenece a productId
        var productEntity = optionalProduct.get();
        var sellerEntity = optionalSeller.get();

        if(!productEntity.getSellerId().equals(sellerEntity.getId())){
            throw new ProcessSaleException(String.format("El producto con id %s no pertenece al vendedor con id %s.", productEntity.getId(), sellerEntity.getId()));
        }

        var product = Product.builder()
                .id(productEntity.getId())
                .stock(productEntity.getStock())
                .name(productEntity.getName())
                .price(Price.builder().value(productEntity.getPrice()).build())
                .description(productEntity.getDescription())
                .seller(Seller.builder().id(productEntity.getSellerId()).build())
                .category(productEntity.getCategory())
                .build();

        product.removeStock(1);

        var productUpdated = updateProductAdapter.update(
                ProductEntity.builder()
                        .id(product.getId())
                        .stock(product.getStock())
                        .name(product.getName())
                        .price(product.getPrice().getValue())
                        .description(product.getDescription())
                        .sellerId(product.getSeller().getId())
                        .category(product.getCategory())
                        .build()
        );

        return SaleResponse.builder()
                .productId(productUpdated.getId())
                .sellerId(sellerEntity.getId())
                .total(product.getPrice())
                .build();
    }
}
