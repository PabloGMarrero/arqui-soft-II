package com.arqui.soft.freemarket.seller.architecture.adapters.out;

import com.arqui.soft.freemarket.seller.domain.ports.out.CreateSellerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoCreateSeller implements CreateSellerAdapter {

    private final MongoSellerRepository sellerRepository;

    public MongoCreateSeller(MongoSellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerEntity create(SellerEntity seller) {
        return sellerRepository.save(seller);
    }
}
