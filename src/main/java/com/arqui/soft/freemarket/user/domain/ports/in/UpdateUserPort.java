package com.arqui.soft.freemarket.user.domain.ports.in;

import com.arqui.soft.freemarket.commons.exceptions.UserDoestNotExistException;
import com.arqui.soft.freemarket.user.architecture.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;

public interface UpdateUserPort {
    User update(String userId, UpdateUserRequest userRequest) throws UserDoestNotExistException;
}
