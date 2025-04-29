package com.arqui.soft.freemarket.product.infrastructure.adapters.in.request;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateProductRequestFixture {
    public static CreateProductRequest withDefaults() {

        return CreateProductRequest.builder()
                .name("NAME")
                .description("DESCRIPTION")
                .price(BigDecimal.ONE)
                .stock(10)
                .sellerId(UUID.randomUUID().toString())
                .category("CATEGORY")
                .build();
    }
}
