package com.arqui.soft.freemarket.product.domain.ports.out;

import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntity;

public interface UpdateProductAdapter {
    ProductEntity update(ProductEntity product);
}
