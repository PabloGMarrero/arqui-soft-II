package com.arqui.soft.freemarket.product.domain.ports.out;

import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface GetProductAdapter {
    Optional<ProductEntity> getById(String productId);

    List<ProductEntity> getProductByName(String name);

    List<ProductEntity> getProductByCategory(String category);
}
