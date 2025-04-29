package com.arqui.soft.freemarket.product.infrastructure.adapters.out;

import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class MongoGetProduct implements GetProductAdapter {
    private final MongoProductRepository productRepository;

    public MongoGetProduct(MongoProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductEntity> getById(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<ProductEntity> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<ProductEntity> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<ProductEntity> getProductsGreaterThan(BigDecimal price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<ProductEntity> getProductsLessThan(BigDecimal price) {
        return productRepository.findByPriceLessThan(price);
    }

    @Override
    public List<ProductEntity> getProductsBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
