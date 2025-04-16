package com.arqui.soft.freemarket.seller.architecture.adapters.out;

import com.arqui.soft.freemarket.seller.domain.model.Seller;
import com.arqui.soft.freemarket.user.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoSellerRepository extends MongoRepository<Seller, String> {
    Optional<Seller> findByEmail_Value(String email);
}
