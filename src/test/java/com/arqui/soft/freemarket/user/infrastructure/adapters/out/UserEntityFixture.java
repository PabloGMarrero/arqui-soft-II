package com.arqui.soft.freemarket.user.infrastructure.adapters.out;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;

import java.util.UUID;

public class UserEntityFixture {

    public static final String ID = UUID.randomUUID().toString();

    public static UserEntity withDefaults() throws InvalidEmailException {
        return UserEntity.builder()
                .id(ID)
                .email(new Email("email@google.com"))
                .name("name")
                .build();
    }
}
