package com.arqui.soft.freemarket.user.domain.usecase;

import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.in.DeleteUserPort;
import com.arqui.soft.freemarket.user.domain.ports.out.DeleteUserAdapter;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase implements DeleteUserPort {

    private final DeleteUserAdapter deleteUser;

    public DeleteUserUseCase(DeleteUserAdapter deleteUser) {
        this.deleteUser = deleteUser;
    }

    @Override
    public void delete(String userId) {

        //validacion si existe?
        //var user = User.builder().build();

        deleteUser.delete(userId);
    }
}
