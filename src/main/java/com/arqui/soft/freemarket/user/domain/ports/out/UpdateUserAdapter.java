package com.arqui.soft.freemarket.user.domain.ports.out;

import com.arqui.soft.freemarket.user.infrastructure.adapters.out.UserEntity;

public interface UpdateUserAdapter {
    UserEntity update(UserEntity userEntity);
}
