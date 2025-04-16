package com.arqui.soft.freemarket.user.domain.usecase;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.domain.ports.out.CreateUserAdapter;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.in.CreateUserPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements CreateUserPort {

    private final CreateUserAdapter createUserAdapter;

    public CreateUserUseCase(CreateUserAdapter createUserAdapter) {
        this.createUserAdapter = createUserAdapter;
    }

    @Override
    public User create(CreateUserRequest user) {

        //validaciones

        return createUserAdapter.create(user);
    }
}
