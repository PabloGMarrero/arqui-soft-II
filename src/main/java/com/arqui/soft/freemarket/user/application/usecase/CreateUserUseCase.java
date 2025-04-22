package com.arqui.soft.freemarket.user.application.usecase;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.user.architecture.adapters.out.UserEntity;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.in.CreateUserPort;
import com.arqui.soft.freemarket.user.domain.ports.out.CreateUserAdapter;
import com.arqui.soft.freemarket.user.domain.ports.out.GetUserAdapter;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements CreateUserPort {

    private final CreateUserAdapter createUserAdapter;
    private final GetUserAdapter getUserAdapter;

    public CreateUserUseCase(CreateUserAdapter createUserAdapter, GetUserAdapter getUserAdapter) {
        this.createUserAdapter = createUserAdapter;
        this.getUserAdapter = getUserAdapter;
    }

    @Override
    public User create(CreateUserRequest createUserRequest) throws InvalidEmailException, EmailAlreadyExistException {
        var email = new Email(createUserRequest.getEmail());

        if (getUserAdapter.getById(email.getValue()).isPresent()) {
            throw new EmailAlreadyExistException("Email ya existente.");
        }

        var user = UserEntity.builder()
                .email(email)
                .name(createUserRequest.getName())
                .lastname(createUserRequest.getLastname())
                .build();

        var userCreated = createUserAdapter.create(user);

        return User.builder()
                .id(userCreated.getId())
                .name(userCreated.getName())
                .lastname(userCreated.getLastname())
                .email(userCreated.getEmail())
                .build();
    }
}
