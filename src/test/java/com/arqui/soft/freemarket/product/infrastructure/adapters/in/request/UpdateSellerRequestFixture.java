package com.arqui.soft.freemarket.product.infrastructure.adapters.in.request;

import com.arqui.soft.freemarket.seller.infrastructure.adapters.in.request.UpdateSellerRequest;

public class UpdateSellerRequestFixture {
    public static UpdateSellerRequest withDefaults() {
        return UpdateSellerRequest.builder()
                .email("EMAIL")
                .name("NAME")
                .build();
    }

    public static UpdateSellerRequest withoutName() {
        return UpdateSellerRequest.builder()
                .email("EMAIL")
                .build();
    }
}
