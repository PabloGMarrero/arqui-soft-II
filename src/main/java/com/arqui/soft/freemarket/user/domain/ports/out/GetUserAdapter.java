package com.arqui.soft.freemarket.user.domain.ports.out;

import com.arqui.soft.freemarket.user.domain.model.User;

import java.util.Optional;

public interface GetUserAdapter {
    Optional<User> getById(String value);
}
