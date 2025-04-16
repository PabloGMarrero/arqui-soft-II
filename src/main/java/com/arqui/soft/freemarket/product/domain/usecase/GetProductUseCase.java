package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.GetProductPort;
import org.springframework.stereotype.Service;

@Service
public class GetProductUseCase implements GetProductPort {
    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public Product getProductByCategory(String category) {
        return null;
    }
}
