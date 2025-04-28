package com.arqui.soft.freemarket.product.domain.ports.out;

import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;

public interface CreateProductAdapter {
    ProductEntity create(ProductEntity product);
}
