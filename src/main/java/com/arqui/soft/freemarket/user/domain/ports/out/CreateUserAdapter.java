package com.arqui.soft.freemarket.user.domain.ports.out;

import com.arqui.soft.freemarket.user.architecture.adapters.out.UserEntity;

public interface CreateUserAdapter {
    UserEntity create(UserEntity user);
}
