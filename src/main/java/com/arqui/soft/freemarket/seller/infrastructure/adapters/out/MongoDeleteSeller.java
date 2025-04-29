package com.arqui.soft.freemarket.seller.infrastructure.adapters.out;

import com.arqui.soft.freemarket.seller.domain.ports.out.DeleteSellerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoDeleteSeller implements DeleteSellerAdapter {
    private final MongoSellerRepository sellerRepository;

    public MongoDeleteSeller(MongoSellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void delete(String userId) {
        sellerRepository.deleteById(userId);
    }
}
