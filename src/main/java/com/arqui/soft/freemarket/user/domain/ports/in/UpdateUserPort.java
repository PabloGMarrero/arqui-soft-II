package com.arqui.soft.freemarket.user.domain.ports.in;

import com.arqui.soft.freemarket.commons.exceptions.UserDoesNotExistException;
import com.arqui.soft.freemarket.user.infrastructure.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;

public interface UpdateUserPort {
    User update(String userId, UpdateUserRequest userRequest) throws UserDoesNotExistException;
}
