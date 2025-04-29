package com.arqui.soft.freemarket.sale.infrastructure.adapters.in.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaleRequest {
    private String productId;
    private String sellerId;
}
