package com.arqui.soft.freemarket.user.infrastructure.adapters.out;

import com.arqui.soft.freemarket.user.domain.ports.out.GetUserAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoGetUser implements GetUserAdapter {

    private final MongoUserRepository userRepository;

    public MongoGetUser(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> getById(String value) {
        return userRepository.findByEmail_Value(value);
    }
}
