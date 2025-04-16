package com.arqui.soft.freemarket.product.domain.model;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Getter
@Document(collection = "product")
@Builder
public class Product {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "description")
    private String description;

    @Field(name = "price")
    private Price price;

    @Field(name = "stock")
    private Integer stock;

    @DBRef
    private Seller seller;

    public void addStock(int amount) {
        this.stock += amount;
    }

    public void removeStock(int amount) {
        if (amount > stock) throw new IllegalArgumentException("Stock insuficiente");
        this.stock -= amount;
    }
}
