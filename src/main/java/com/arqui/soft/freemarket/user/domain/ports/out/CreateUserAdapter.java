package com.arqui.soft.freemarket.user.domain.ports.out;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;

public interface CreateUserAdapter {
    User create(CreateUserRequest user);
}
