package com.arqui.soft.freemarket.user.infrastructure.adapters.in.request;

public class CreateUserRequestFixture {
    public static CreateUserRequest withWrongEmail() {
        return CreateUserRequest.builder()
                .email("emial")
                .name("name")
                .build();
    }

    public static CreateUserRequest withDefaults() {
        return CreateUserRequest.builder()
                .email("email@google.com")
                .name("name")
                .build();
    }
}
