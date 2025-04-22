package com.arqui.soft.freemarket.seller.application.usecase;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.seller.architecture.adapters.out.SellerEntity;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import com.arqui.soft.freemarket.seller.architecture.adapters.in.request.CreateSellerRequest;
import com.arqui.soft.freemarket.seller.domain.ports.out.CreateSellerAdapter;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import com.arqui.soft.freemarket.seller.domain.ports.in.CreateSellerPort;
import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public class CreateSellerUseCase implements CreateSellerPort {

    private final CreateSellerAdapter createSellerAdapter;
    private final GetSellerAdapter getSellerAdapter;

    public CreateSellerUseCase(CreateSellerAdapter createSellerAdapter, GetSellerAdapter getSellerAdapter) {
        this.createSellerAdapter = createSellerAdapter;
        this.getSellerAdapter = getSellerAdapter;
    }

    @Override
    public Seller create(CreateSellerRequest createSellerRequest) throws InvalidEmailException, EmailAlreadyExistException {
        var email = new Email(createSellerRequest.getEmail());

        if (getSellerAdapter.getByEmail(email.getValue()).isPresent()) {
            throw new EmailAlreadyExistException("Email ya existente.");
        }

        var seller = SellerEntity.builder()
                .email(email)
                .name(createSellerRequest.getName())
                .build();

        var sellerCreated = createSellerAdapter.create(seller);

        return Seller.builder()
                .id(sellerCreated.getId())
                .products(sellerCreated.getProducts())
                .email(sellerCreated.getEmail())
                .name(sellerCreated.getName())
                .build();

    }
}
