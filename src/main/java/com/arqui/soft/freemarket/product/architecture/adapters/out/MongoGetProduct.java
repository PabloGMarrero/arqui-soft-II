package com.arqui.soft.freemarket.product.architecture.adapters.out;

import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import org.springframework.stereotype.Component;

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
}
