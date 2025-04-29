package com.arqui.soft.freemarket.user.infrastructure.adapters.out;

import com.arqui.soft.freemarket.commons.Email;
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
@Builder
@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;

    @Field(name = "lastname")
    private String lastname;

    @Field(name = "name")
    private String name;

    @Field(name = "email")
    private Email email;
}
