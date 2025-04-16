package com.arqui.soft.freemarket.user.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Getter
@Document(collection = "users")
@Builder
public class User {

    @Id
    private Integer id;

    @Field(name = "lastname")
    private String lastname;

    @Field(name = "name")
    private String name;

    @Field(name = "email")
    private String email;
}
