package com.arqui.soft.freemarket.user.architecture.adapters.out;

import com.arqui.soft.freemarket.user.domain.model.User;
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
    public Optional<User> getById(String value) {
        return userRepository.findByEmail_Value(value);
    }
}
