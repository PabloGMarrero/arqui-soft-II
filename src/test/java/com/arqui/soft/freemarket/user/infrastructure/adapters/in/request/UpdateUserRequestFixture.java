package com.arqui.soft.freemarket.user.infrastructure.adapters.in.request;

public class UpdateUserRequestFixture {
    public static UpdateUserRequest withDefaults() {
        return UpdateUserRequest.builder()
                .name("name")
                .lastname("lastname")
                .build();
    }

    public static UpdateUserRequest withoutName() {
        return UpdateUserRequest.builder()
                .lastname("lastname")
                .build();
    }
}
