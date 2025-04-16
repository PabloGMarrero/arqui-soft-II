package com.arqui.soft.freemarket.user.architecture.adapters.out;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.out.UpdateUserAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoUpdateUser implements UpdateUserAdapter {
    private final MongoUserRepository userRepository;

    public MongoUpdateUser(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User update(UpdateUserRequest updateUserRequest) {
        var user = User.builder()
                //TODO completar
                .build();
        return userRepository.save(user);
    }
}
