package com.arqui.soft.freemarket.seller.infrastructure.adapters.in.request;

public class CreateSellerRequestFixture {
    public static CreateSellerRequest withWrongEmail() {
        return CreateSellerRequest.builder()
                .name("NAME")
                .email("EMAIL")
                .build();
    }

    public static CreateSellerRequest withDefaults() {
        return CreateSellerRequest.builder()
                .name("NAME")
                .email("email@gmai.com")
                .build();
    }
}
