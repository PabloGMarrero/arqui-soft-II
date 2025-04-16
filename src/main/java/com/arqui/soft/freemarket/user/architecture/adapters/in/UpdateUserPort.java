package com.arqui.soft.freemarket.user.architecture.adapters.in;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;

public interface UpdateUserPort {
    User update(String userId, UpdateUserRequest user);
}
