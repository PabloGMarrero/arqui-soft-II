package com.arqui.soft.freemarket.user.infrastructure.adapters.in.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequest {

    private String name;
    private String lastname;
    private String email;
}
