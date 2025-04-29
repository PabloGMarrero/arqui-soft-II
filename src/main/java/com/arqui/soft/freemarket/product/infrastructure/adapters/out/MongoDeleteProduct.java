package com.arqui.soft.freemarket.product.infrastructure.adapters.out;

import com.arqui.soft.freemarket.product.domain.ports.out.DeleteProductAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoDeleteProduct implements DeleteProductAdapter {

    private final MongoProductRepository productRepository;

    public MongoDeleteProduct(MongoProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void delete(String productId) {
        productRepository.deleteById(productId);
    }
}
