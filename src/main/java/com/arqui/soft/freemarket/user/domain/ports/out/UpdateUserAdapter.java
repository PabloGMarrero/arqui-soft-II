package com.arqui.soft.freemarket.user.domain.ports.out;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;

public interface UpdateUserAdapter {
    User update(UpdateUserRequest user);
}
