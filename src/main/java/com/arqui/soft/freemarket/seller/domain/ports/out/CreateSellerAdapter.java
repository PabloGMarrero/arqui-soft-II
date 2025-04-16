package com.arqui.soft.freemarket.seller.domain.ports.out;

import com.arqui.soft.freemarket.seller.domain.model.Seller;

public interface CreateSellerAdapter {
    Seller create(Seller seller);
}
