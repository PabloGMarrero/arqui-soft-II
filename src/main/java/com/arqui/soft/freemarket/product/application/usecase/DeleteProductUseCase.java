package com.arqui.soft.freemarket.product.application.usecase;

import com.arqui.soft.freemarket.product.domain.ports.in.DeleteProductPort;
import com.arqui.soft.freemarket.product.domain.ports.out.DeleteProductAdapter;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase implements DeleteProductPort {
    private final DeleteProductAdapter deleteProduct;

    public DeleteProductUseCase(DeleteProductAdapter deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    @Override
    public void delete(String productId) {
        deleteProduct.delete(productId);
    }
}
