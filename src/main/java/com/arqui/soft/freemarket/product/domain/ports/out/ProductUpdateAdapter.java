package com.arqui.soft.freemarket.product.domain.ports.out;

import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;

public interface ProductUpdateAdapter {
    ProductEntity update(ProductEntity product);
}
