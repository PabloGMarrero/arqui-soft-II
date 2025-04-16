package com.arqui.soft.freemarket.seller.domain.usecase;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
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

        if (getSellerAdapter.getById(email.getValue()).isPresent()) {
            throw new EmailAlreadyExistException("Email ya existente.");
        }

        var seller = Seller.builder()
                .email(email)
                .name(createSellerRequest.getName())
                .build();

        return createSellerAdapter.create(seller);
    }
}
