package com.arqui.soft.freemarket.seller.domain.ports.out;

import com.arqui.soft.freemarket.seller.infrastructure.adapters.out.SellerEntity;

public interface UpdateSellerAdapter {
    SellerEntity update(SellerEntity seller);
}
