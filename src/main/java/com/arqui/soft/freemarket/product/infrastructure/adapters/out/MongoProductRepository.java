package com.arqui.soft.freemarket.product.infrastructure.adapters.out;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface MongoProductRepository extends MongoRepository<ProductEntity, String> {
    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByCategory(String category);

    List<ProductEntity> findByPriceGreaterThan(BigDecimal price);
    List<ProductEntity> findByPriceLessThan(BigDecimal price);
    List<ProductEntity> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
