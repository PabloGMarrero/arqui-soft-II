package com.arqui.soft.freemarket.seller.architecture.adapters.out;

import com.arqui.soft.freemarket.seller.domain.model.Seller;
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
    public Optional<Seller> getById(String value) {
        return sellerRepository.findByEmail_Value(value);
    }
}
