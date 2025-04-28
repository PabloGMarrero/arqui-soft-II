package com.arqui.soft.freemarket.seller.domain.model;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.product.domain.model.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor(access = AccessLevel.MODULE)
@Getter
@Builder
public class Seller {
    private String id;
    private String name;
    private Email email;
    private List<Product> products;
}
