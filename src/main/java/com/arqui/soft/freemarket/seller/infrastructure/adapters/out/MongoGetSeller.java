package com.arqui.soft.freemarket.seller.infrastructure.adapters.out;

import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoGetSeller implements GetSellerAdapter {

    private final MongoSellerRepository sellerRepository;

    public MongoGetSeller(MongoSellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Optional<SellerEntity> getByEmail(String value) {
        return sellerRepository.findByEmail_Value(value);
    }

    @Override
    public Optional<SellerEntity> getById(String sellerId) {
        return sellerRepository.findById(sellerId);
    }
}
