package com.arqui.soft.freemarket.user.infrastructure.adapters.in.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateUserRequest {
    private String name;
    private String lastname;
}
