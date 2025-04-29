package com.arqui.soft.freemarket.sale.infrastructure.adapters.in.response;

import com.arqui.soft.freemarket.commons.Price;
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
    private Price total;
}
