package com.arqui.soft.freemarket.seller.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.seller.architecture.adapters.in.request.UpdateSellerRequest;
import com.arqui.soft.freemarket.seller.architecture.adapters.out.SellerEntity;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import com.arqui.soft.freemarket.seller.domain.ports.in.UpdateSellerPort;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import com.arqui.soft.freemarket.seller.domain.ports.out.UpdateSellerAdapter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class UpdateSellerUseCase implements UpdateSellerPort {
    private final UpdateSellerAdapter updateSellerAdapter;
    private final GetSellerAdapter getSellerAdapter;

    public UpdateSellerUseCase(UpdateSellerAdapter updateSellerAdapter, GetSellerAdapter getSellerAdapter) {
        this.updateSellerAdapter = updateSellerAdapter;
        this.getSellerAdapter = getSellerAdapter;
    }

    @Override
    public Seller update(String sellerId, UpdateSellerRequest updateSellerRequest) throws SellerDoesNotExistException {

        var optionalSeller = getSellerAdapter.getById(sellerId);
        if (optionalSeller.isEmpty()) {
            throw new SellerDoesNotExistException(sellerId);
        }
        var sellerFound = optionalSeller.get();
        var sellerBuilder = SellerEntity.builder();

        if (Strings.isNotBlank(updateSellerRequest.getName())){
            sellerBuilder.name(updateSellerRequest.getName());
        }
        else {
            sellerBuilder.name(sellerFound.getName());
        }


        var userEntity = updateSellerAdapter.update(
                sellerBuilder.id(sellerFound.getId())
                        .build()
        );

        return Seller.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
    }
}
