package com.arqui.soft.freemarket.user.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.UserDoestNotExistException;
import com.arqui.soft.freemarket.product.domain.ports.in.UpdateProductPort;
import com.arqui.soft.freemarket.user.architecture.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.architecture.adapters.out.UserEntity;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.in.UpdateUserPort;
import com.arqui.soft.freemarket.user.domain.ports.out.GetUserAdapter;
import com.arqui.soft.freemarket.user.domain.ports.out.UpdateUserAdapter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdateUserUseCase implements UpdateUserPort {
    private final UpdateUserAdapter updateUserAdapter;
    private final GetUserAdapter getUserAdapter;

    public UpdateUserUseCase(UpdateUserAdapter updateUserAdapter, GetUserAdapter getUserAdapter) {
        this.updateUserAdapter = updateUserAdapter;
        this.getUserAdapter = getUserAdapter;
    }

    @Override
    public User update(String userId, UpdateUserRequest updateUserRequest) throws UserDoestNotExistException {

        var optionalUser = getUserAdapter.getById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserDoestNotExistException(userId);
        }
        var userFound = optionalUser.get();
        var userBuilder = UserEntity.builder();

        if (Strings.isNotBlank(updateUserRequest.getName())){
            userBuilder.name(updateUserRequest.getName());
        }
        else {
            userBuilder.name(userFound.getName());
        }


        if (!Objects.isNull(updateUserRequest.getLastname())){
            userBuilder.lastname(updateUserRequest.getLastname());
        }
        else {
            userBuilder.lastname(userFound.getLastname());
        }


        var userEntity = updateUserAdapter.update(
                userBuilder.id(userFound.getId())
                        .build()
        );

        return User.builder()
                .id(userEntity.getId())
                .lastname(userEntity.getLastname())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
    }
}
