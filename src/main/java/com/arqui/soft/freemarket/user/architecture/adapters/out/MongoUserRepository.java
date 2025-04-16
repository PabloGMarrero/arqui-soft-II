package com.arqui.soft.freemarket.user.architecture.adapters.out;

import com.arqui.soft.freemarket.user.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail_Value(String email);
}
