package com.arqui.soft.freemarket.product.architecture.adapters.out;

import com.arqui.soft.freemarket.product.domain.ports.out.ProductUpdateAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoUpdateProduct implements ProductUpdateAdapter {
    private final MongoProductRepository productRepository;

    public MongoUpdateProduct(MongoProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity update(ProductEntity product) {
        return productRepository.save(product);
    }
}
