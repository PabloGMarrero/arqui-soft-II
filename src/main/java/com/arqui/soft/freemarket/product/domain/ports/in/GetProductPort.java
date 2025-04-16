package com.arqui.soft.freemarket.product.domain.ports.in;

import com.arqui.soft.freemarket.product.domain.model.Product;

public interface GetProductPort {
    Product getProductByName(String name);

    Product getProductByCategory(String category);
}
