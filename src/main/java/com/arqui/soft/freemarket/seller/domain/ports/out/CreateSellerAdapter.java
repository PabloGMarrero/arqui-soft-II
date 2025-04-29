package com.arqui.soft.freemarket.seller.domain.ports.out;

import com.arqui.soft.freemarket.seller.infrastructure.adapters.out.SellerEntity;

public interface CreateSellerAdapter {
    SellerEntity create(SellerEntity seller);
}
