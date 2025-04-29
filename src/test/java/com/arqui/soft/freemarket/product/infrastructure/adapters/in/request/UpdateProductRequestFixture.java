package com.arqui.soft.freemarket.product.infrastructure.adapters.in.request;

import java.math.BigDecimal;

public class UpdateProductRequestFixture {
    public static UpdateProductRequest withStockAndPrice() {
        return UpdateProductRequest.builder()
                .stock(10)
                .price(BigDecimal.ONE)
                .build();
    }

    public static UpdateProductRequest withDefaults() {
        return UpdateProductRequest.builder()
                .name("NAME")
                .description("DESC")
                .price(BigDecimal.ONE)
                .stock(10)
                .build();
    }
}
