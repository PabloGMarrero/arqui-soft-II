package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.commons.exceptions.ProductDoestNotExistException;
import com.arqui.soft.freemarket.product.architecture.adapters.in.request.UpdateProductRequest;
import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.UpdateProductPort;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import com.arqui.soft.freemarket.product.domain.ports.out.ProductUpdateAdapter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdateProductUseCase implements UpdateProductPort {
    private final ProductUpdateAdapter productUpdateAdapter;
    private final GetProductAdapter getProductAdapter;

    public UpdateProductUseCase(ProductUpdateAdapter productUpdateAdapter, GetProductAdapter getProductAdapter) {
        this.productUpdateAdapter = productUpdateAdapter;
        this.getProductAdapter = getProductAdapter;
    }

    @Override
    public Product update(String productId, UpdateProductRequest productRequest) throws ProductDoestNotExistException {

        var optionalProduct = getProductAdapter.getById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductDoestNotExistException((String.format("El producto con id %s no existe.", productId)));
        }
        var productFinded = optionalProduct.get();
        var productBuilder = ProductEntity.builder();

        if (Strings.isNotBlank(productRequest.getName())){
            productBuilder.name(productRequest.getName());
        }
        else {
            productBuilder.name(productFinded.getName());
        }

        if (Strings.isNotBlank(productRequest.getDescription())){
            productBuilder.description(productRequest.getDescription());
        }
        else {
            productBuilder.description(productFinded.getDescription());
        }

        if (!Objects.isNull(productRequest.getPrice())){
            productBuilder.price(productRequest.getPrice());
        }
        else {
            productBuilder.price(productFinded.getPrice());
        }

        if (!Objects.isNull(productRequest.getStock())){
            productBuilder.stock(productRequest.getStock());
        }
        else {
            productBuilder.stock(productFinded.getStock());
        }

        var productUpdated = productUpdateAdapter.update(
                productBuilder.id(productFinded.getId())
                        .build()
        );

        return Product.builder()
                .id(productUpdated.getId())
                .price(Price.builder()
                        .value(productUpdated.getPrice())
                        .build()
                )
                .description(productUpdated.getDescription())
                .name(productUpdated.getName())
                .stock(productUpdated.getStock())
                .build();
    }
}
