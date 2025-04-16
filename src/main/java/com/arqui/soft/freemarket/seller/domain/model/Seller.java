package com.arqui.soft.freemarket.seller.domain.model;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.product.domain.model.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Getter
@Document(collection = "seller")
@Builder
public class Seller {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "email")
    private Email email;

    @Field(name = "products")
    private List<Product> products;

    public void addProduct(Product aProduct) {
        products.add(aProduct);
    }
}
