package com.arqui.soft.freemarket.product.architecture.adapters.out;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoProductRepository extends MongoRepository<ProductEntity, String> {
    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByCategory(String category);
}
