package com.arqui.soft.freemarket.seller.domain.ports.out;

import com.arqui.soft.freemarket.seller.architecture.adapters.out.SellerEntity;

import java.util.Optional;

public interface GetSellerAdapter {
    Optional<SellerEntity> getByEmail(String value);

    Optional<SellerEntity> getById(String sellerId);
}
