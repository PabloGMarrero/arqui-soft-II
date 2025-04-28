package com.arqui.soft.freemarket.product.domain.model.filter;

import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductMapperAdapter;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class GreaterThanFilter implements ProductFilterStrategy{
    private final GetProductAdapter getProductAdapter;
    private final ProductMapperAdapter productMapper;

    public GreaterThanFilter(GetProductAdapter getProductAdapter, ProductMapperAdapter productMapper) {
        this.getProductAdapter = getProductAdapter;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> filter(BigDecimal minPrice, BigDecimal maxPrice, BigDecimal price) throws InvalidFilterParameter {
        if(price == null)
        {
            throw new InvalidFilterParameter("El filtro de busqueda mayor que debe tener el parámetro price");
        }
        var products = getProductAdapter.getProductsGreaterThan(price);
        return productMapper.mapProductsToModel(products);
    }
}
