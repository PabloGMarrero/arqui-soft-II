package com.arqui.soft.freemarket.seller.infrastructure.adapters.out;

import java.util.UUID;

public class SellerEntityFixture {

    public static final String ID = UUID.randomUUID().toString();

    public static SellerEntity withDefaults() {
        return SellerEntity.builder()
                .id(ID)
                .build();
    }
}
