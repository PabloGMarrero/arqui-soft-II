package com.arqui.soft.freemarket.user.domain.ports.in;

import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;

public interface CreateUserPort {
    User create(CreateUserRequest user) throws InvalidEmailException, EmailAlreadyExistException;
}
