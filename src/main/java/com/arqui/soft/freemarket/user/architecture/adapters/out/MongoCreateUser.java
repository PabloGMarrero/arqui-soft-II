package com.arqui.soft.freemarket.user.architecture.adapters.out;

import com.arqui.soft.freemarket.user.domain.ports.out.CreateUserAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoCreateUser implements CreateUserAdapter {

    private final MongoUserRepository userRepository;

    public MongoCreateUser(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }
}
