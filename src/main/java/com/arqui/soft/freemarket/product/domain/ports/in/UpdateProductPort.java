package com.arqui.soft.freemarket.product.domain.ports.in;

import com.arqui.soft.freemarket.product.architecture.adapters.in.request.UpdateProductRequest;
import com.arqui.soft.freemarket.product.domain.model.Product;

public interface UpdateProductPort {
    Product update(String productId, UpdateProductRequest productRequest);
}
