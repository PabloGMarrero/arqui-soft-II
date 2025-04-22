package com.arqui.soft.freemarket.product.architecture.adapters.out;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

@Getter
@Document(collection = "product")
@Builder
public class ProductEntity {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "description")
    private String description;

    @Field(name = "category")
    private String category;

    @Field(name = "price", targetType = FieldType.DECIMAL128)
    private BigDecimal price;

    @Field(name = "stock")
    private Integer stock;

    /*@DBRef
    private SellerEntity seller;*/
    @Field(name = "sellerId")
    private String sellerId;
}
