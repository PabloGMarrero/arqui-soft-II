package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.product.architecture.adapters.in.request.CreateProductRequest;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.CreateProductPort;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase implements CreateProductPort {
    @Override
    public Product create(CreateProductRequest createProductRequest, String sellerId) {
        return null;
    }
}
