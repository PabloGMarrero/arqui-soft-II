package com.arqui.soft.freemarket.seller.domain.ports.in;

import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.seller.architecture.adapters.in.request.UpdateSellerRequest;
import com.arqui.soft.freemarket.seller.domain.model.Seller;

public interface UpdateSellerPort {
    Seller update(String userId, UpdateSellerRequest updateSellerRequest) throws SellerDoesNotExistException;
}
