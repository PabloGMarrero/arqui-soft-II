package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.product.architecture.adapters.in.request.UpdateProductRequest;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.UpdateProductPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCase implements UpdateProductPort {

    @Override
    public Product update(String productId, UpdateProductRequest productRequest) {
        return null;
    }
}
