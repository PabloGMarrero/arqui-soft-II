package com.arqui.soft.freemarket.product.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.FilterIsNotAllowedException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductMapperAdapter;
import com.arqui.soft.freemarket.product.domain.config.ProductFilterStrategyConfiguration;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.GetProductPort;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GetProductUseCase implements GetProductPort {
    private final GetProductAdapter getProductAdapter;
    private final ProductFilterStrategyConfiguration productFilterStrategyConfiguration;
    private final ProductMapperAdapter productMapper;

    public GetProductUseCase(GetProductAdapter getProductAdapter, ProductFilterStrategyConfiguration productFilterStrategyConfiguration, ProductMapperAdapter productMapper) {
        this.getProductAdapter = getProductAdapter;
        this.productFilterStrategyConfiguration = productFilterStrategyConfiguration;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getProductByName(String name) {
        var products = getProductAdapter.getProductByName(name);

        return productMapper.mapProductsToModel(products);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        var products = getProductAdapter.getProductByCategory(category);

        return productMapper.mapProductsToModel(products);
    }

    @Override
    public List<Product> filter(String filterType, BigDecimal minPrice, BigDecimal maxPrice, BigDecimal value) throws FilterIsNotAllowedException, InvalidFilterParameter {
        var filter = productFilterStrategyConfiguration.getStrategy(filterType);
        if (filter == null){
            throw new FilterIsNotAllowedException(String.format("El filtro utilizado %s no es correcto, debe ser uno del listado en la documentación", filterType));
        }

        return filter.filter(minPrice, maxPrice, value);
    }
}
