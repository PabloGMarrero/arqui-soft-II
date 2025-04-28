package com.arqui.soft.freemarket.user.domain.model;

import com.arqui.soft.freemarket.commons.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Getter
@Builder
public class User {

    private String id;
    private String lastname;
    private String name;
    private Email email;
}
