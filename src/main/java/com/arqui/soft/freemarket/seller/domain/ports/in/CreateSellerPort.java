package com.arqui.soft.freemarket.seller.domain.ports.in;

import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.seller.infrastructure.adapters.in.request.CreateSellerRequest;
import com.arqui.soft.freemarket.seller.domain.model.Seller;

public interface CreateSellerPort {
    Seller create(CreateSellerRequest seller) throws InvalidEmailException, EmailAlreadyExistException;
}
