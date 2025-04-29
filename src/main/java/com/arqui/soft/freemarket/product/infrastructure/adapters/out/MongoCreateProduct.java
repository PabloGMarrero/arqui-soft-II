package com.arqui.soft.freemarket.product.infrastructure.adapters.out;

import com.arqui.soft.freemarket.product.domain.ports.out.CreateProductAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoCreateProduct implements CreateProductAdapter {

    private final MongoProductRepository productRepository;

    public MongoCreateProduct(MongoProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity create(ProductEntity product) {
        return productRepository.save(product);
    }
}
