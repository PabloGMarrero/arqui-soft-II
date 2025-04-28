package com.arqui.soft.freemarket.product.domain.ports.out;

import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface GetProductAdapter {
    Optional<ProductEntity> getById(String productId);

    List<ProductEntity> getProductByName(String name);

    List<ProductEntity> getProductByCategory(String category);

    List<ProductEntity> getProductsGreaterThan(BigDecimal price);
    List<ProductEntity> getProductsLessThan(BigDecimal price);
    List<ProductEntity> getProductsBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
