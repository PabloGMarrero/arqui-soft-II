package com.arqui.soft.freemarket.seller.architecture.adapters.out;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoSellerRepository extends MongoRepository<SellerEntity, String> {
    Optional<SellerEntity> findByEmail_Value(String email);
}
