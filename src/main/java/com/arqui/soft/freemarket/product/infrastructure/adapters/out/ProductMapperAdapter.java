package com.arqui.soft.freemarket.product.infrastructure.adapters.out;

import com.arqui.soft.freemarket.product.domain.model.Product;

import java.util.List;

public interface ProductMapperAdapter {
    List<Product> mapProductsToModel(List<ProductEntity> products);
}
