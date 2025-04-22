package com.arqui.soft.freemarket.product.domain.ports.in;

import com.arqui.soft.freemarket.product.domain.model.Product;

import java.util.List;

public interface GetProductPort {
    List<Product> getProductByName(String name);

    List<Product> getProductByCategory(String category);
}
