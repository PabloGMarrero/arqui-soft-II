package com.arqui.soft.freemarket.product.domain.model;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.MODULE)
@AllArgsConstructor(access = AccessLevel.MODULE)
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

/*    public Product(String id, String name, String description, Price price, Integer stock, Seller seller, String category){
        if(price.getValue().compareTo(BigDecimal.ZERO)<0){
            throw new IllegalArgumentException("Stock no puede ser negativo");
        }
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.category = category;
    }*/

    public void removeStock(int amount) {
        if (amount > stock) throw new IllegalArgumentException("Stock insuficiente");
        if (stock<1) throw new IllegalArgumentException("Stock insuficiente");
        this.stock -= amount;
    }
}
