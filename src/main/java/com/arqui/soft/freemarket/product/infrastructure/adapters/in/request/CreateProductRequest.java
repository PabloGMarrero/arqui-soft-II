package com.arqui.soft.freemarket.product.infrastructure.adapters.in.request;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CreateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String sellerId;
    private String category;
}
