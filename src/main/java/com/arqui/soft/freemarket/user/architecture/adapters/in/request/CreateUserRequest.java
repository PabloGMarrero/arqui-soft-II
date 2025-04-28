package com.arqui.soft.freemarket.user.architecture.adapters.in.request;

import lombok.Getter;

@Getter
public class CreateUserRequest {

    private String name;
    private String lastname;
    private String email;
}
