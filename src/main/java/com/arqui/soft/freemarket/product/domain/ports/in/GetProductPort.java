package com.arqui.soft.freemarket.product.domain.ports.in;

import com.arqui.soft.freemarket.commons.exceptions.FilterIsNotAllowedException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.product.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface GetProductPort {
    List<Product> getProductByName(String name);

    List<Product> getProductByCategory(String category);

    List<Product> filter(String filterType, BigDecimal minPrice, BigDecimal maxPrice, BigDecimal value) throws FilterIsNotAllowedException, InvalidFilterParameter;
}
