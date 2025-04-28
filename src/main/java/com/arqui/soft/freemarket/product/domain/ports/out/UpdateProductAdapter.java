package com.arqui.soft.freemarket.product.domain.ports.out;

import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;

public interface UpdateProductAdapter {
    ProductEntity update(ProductEntity product);
}
