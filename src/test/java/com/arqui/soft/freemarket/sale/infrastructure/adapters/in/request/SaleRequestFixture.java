package com.arqui.soft.freemarket.sale.infrastructure.adapters.in.request;

import java.util.UUID;

public class SaleRequestFixture {

    public static final String PRODUCT_ID = UUID.randomUUID().toString();
    public static final String SELLER_ID = UUID.randomUUID().toString();

    public static SaleRequest withDefaults() {
        return SaleRequest.builder()
                .productId(PRODUCT_ID)
                .sellerId(SELLER_ID)
                .build();
    }
}
