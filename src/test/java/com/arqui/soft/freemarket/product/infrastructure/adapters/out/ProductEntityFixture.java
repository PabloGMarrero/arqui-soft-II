package com.arqui.soft.freemarket.product.infrastructure.adapters.out;

import com.arqui.soft.freemarket.seller.infrastructure.adapters.out.SellerEntityFixture;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductEntityFixture {

    public static final String ID = UUID.randomUUID().toString();

    public static ProductEntity withDefaults() {
        return ProductEntity.builder()
                .id(ID)
                .stock(10)
                .price(BigDecimal.ONE)
                .sellerId(ID)
                .name("NAME")
                .description("DESCRIPTION")
                .category("CATEGORY")
                .build();
    }

    public static ProductEntity withSellerId() {
        return ProductEntity.builder()
                .id(ID)
                .stock(10)
                .price(BigDecimal.ONE)
                .sellerId(SellerEntityFixture.ID)
                .name("NAME")
                .description("DESCRIPTION")
                .category("CATEGORY")
                .build();
    }
}
