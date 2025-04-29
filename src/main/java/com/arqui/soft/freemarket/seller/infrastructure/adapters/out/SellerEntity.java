package com.arqui.soft.freemarket.seller.infrastructure.adapters.out;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.product.domain.model.Product;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "seller")
@Builder
@Getter
public class SellerEntity {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "email")
    private Email email;

    @Field(name = "products")
    private List<Product> products;
}
