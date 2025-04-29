package com.arqui.soft.freemarket.user.infrastructure.adapters.out;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail_Value(String email);
}
