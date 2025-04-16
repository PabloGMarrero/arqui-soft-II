package com.arqui.soft.freemarket.user.domain.usecase;

import com.arqui.soft.freemarket.user.architecture.adapters.in.UpdateUserPort;
import com.arqui.soft.freemarket.user.architecture.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.out.UpdateUserAdapter;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase implements UpdateUserPort {

    private final UpdateUserAdapter updateUserAdapter;

    public UpdateUserUseCase(UpdateUserAdapter updateUserAdapter) {
        this.updateUserAdapter = updateUserAdapter;
    }

    @Override
    public User update(String userId, UpdateUserRequest user) {

        //validar userId existente
        //crear nuevo objeto con el user
        //builder objeto con los nuevos valores
        return updateUserAdapter.update(user);
    }
}
