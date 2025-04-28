package com.arqui.soft.freemarket.user.domain.ports.out;

import com.arqui.soft.freemarket.user.architecture.adapters.out.UserEntity;

import java.util.Optional;

public interface GetUserAdapter {
    Optional<UserEntity> getById(String value);
}
