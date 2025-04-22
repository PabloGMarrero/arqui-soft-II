package com.arqui.soft.freemarket.product.domain.ports.in;

import com.arqui.soft.freemarket.product.architecture.adapters.in.request.CreateProductRequest;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.product.domain.model.Product;

public interface CreateProductPort {
    Product create(CreateProductRequest createProductRequest, String sellerId) throws SellerDoesNotExistException;
}
