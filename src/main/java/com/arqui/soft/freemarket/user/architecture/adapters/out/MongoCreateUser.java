package com.arqui.soft.freemarket.user.architecture.adapters.out;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.out.CreateUserAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoCreateUser implements CreateUserAdapter {

    private final MongoUserRepository userRepository;

    public MongoCreateUser(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserRequest createUserRequest) {
        var user = User.builder()
                .id(1)
                .email(createUserRequest.getEmail())
                .name(createUserRequest.getName())
                .lastname(createUserRequest.getLastname())
                .build();

        return userRepository.save(user);
    }
}
