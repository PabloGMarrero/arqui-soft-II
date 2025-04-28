package com.arqui.soft.freemarket.product.domain.model.filter;

import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.product.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductFilterStrategy {
        List<Product> filter(BigDecimal minPrice, BigDecimal maxPrice, BigDecimal price) throws InvalidFilterParameter;
}
