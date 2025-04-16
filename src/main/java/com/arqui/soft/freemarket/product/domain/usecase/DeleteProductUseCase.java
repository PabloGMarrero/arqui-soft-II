package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.product.domain.ports.in.DeleteProductPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase implements DeleteProductPort {
    @Override
    public void delete(String productId) {

    }
}
