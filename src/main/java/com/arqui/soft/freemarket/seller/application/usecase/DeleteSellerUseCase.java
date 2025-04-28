package com.arqui.soft.freemarket.seller.application.usecase;

import com.arqui.soft.freemarket.seller.domain.ports.in.DeleteSellerPort;
import com.arqui.soft.freemarket.seller.domain.ports.out.DeleteSellerAdapter;
import com.arqui.soft.freemarket.user.domain.ports.out.DeleteUserAdapter;
import org.springframework.stereotype.Service;

@Service
public class DeleteSellerUseCase implements DeleteSellerPort {

    private final DeleteSellerAdapter sellerAdapter;

    public DeleteSellerUseCase(DeleteSellerAdapter sellerAdapter) {
        this.sellerAdapter = sellerAdapter;
    }

    @Override
    public void delete(String sellerId) {
        sellerAdapter.delete(sellerId);
    }
}
