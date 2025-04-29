package com.arqui.soft.freemarket.seller.infrastructure.adapters.out;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoSellerRepository extends MongoRepository<SellerEntity, String> {
    Optional<SellerEntity> findByEmail_Value(String email);
}
