package com.arqui.soft.freemarket.product.architecture.adapters.in.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UpdateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    //private String sellerId;
}
