package com.arqui.soft.freemarket.seller.domain.ports.out;

import com.arqui.soft.freemarket.seller.domain.model.Seller;

import java.util.Optional;

public interface GetSellerAdapter {
    Optional<Seller> getById(String value);
}
