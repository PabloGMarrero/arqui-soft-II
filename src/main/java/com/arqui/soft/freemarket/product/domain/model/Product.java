package com.arqui.soft.freemarket.product.domain.model;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Getter
@Builder
public class Product {

    private String id;
    private String name;
    private String description;
    private Price price;
    private Integer stock;
    private Seller seller;
    private String category;

    public void addStock(int amount) {
        this.stock += amount;
    }

    public void removeStock(int amount) {
        if (amount > stock) throw new IllegalArgumentException("Stock insuficiente");
        if (stock<1) throw new IllegalArgumentException("Stock insuficiente");
        this.stock -= amount;
    }
}
