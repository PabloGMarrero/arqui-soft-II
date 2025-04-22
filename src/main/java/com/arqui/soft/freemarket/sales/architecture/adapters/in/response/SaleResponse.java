package com.arqui.soft.freemarket.sales.architecture.adapters.in.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Getter
@Builder
public class SaleResponse {
    private String productId;
    private String sellerId;
}
