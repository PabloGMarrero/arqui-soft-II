package com.arqui.soft.freemarket.user.infrastructure.adapters.out;

import com.arqui.soft.freemarket.user.domain.ports.out.DeleteUserAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoDeleteUser implements DeleteUserAdapter {
    private final MongoUserRepository userRepository;

    public MongoDeleteUser(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }
}
