package com.arqui.soft.freemarket.seller.infrastructure.adapters.out;

import com.arqui.soft.freemarket.seller.domain.ports.out.UpdateSellerAdapter;
import org.springframework.stereotype.Component;

@Component
public class MongoUpdateSeller implements UpdateSellerAdapter {
    private final MongoSellerRepository sellerRepository;

    public MongoUpdateSeller(MongoSellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerEntity update(SellerEntity seller) {
        return sellerRepository.save(seller);
    }
}
