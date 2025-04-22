package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.product.architecture.adapters.in.request.CreateProductRequest;
import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.CreateProductPort;
import com.arqui.soft.freemarket.product.domain.ports.out.CreateProductAdapter;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import com.arqui.soft.freemarket.seller.domain.ports.out.GetSellerAdapter;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase implements CreateProductPort {

    private final CreateProductAdapter createProductAdapter;
    private final GetSellerAdapter getSellerAdapter;

    public CreateProductUseCase(CreateProductAdapter createProductAdapter, GetSellerAdapter getSellerAdapter) {
        this.createProductAdapter = createProductAdapter;
        this.getSellerAdapter = getSellerAdapter;
    }

    @Override
    public Product create(CreateProductRequest createProductRequest, String sellerId) throws SellerDoesNotExistException {

        var sellerById = getSellerAdapter.getById(sellerId);
        if (sellerById.isEmpty())
        {
            throw new SellerDoesNotExistException(String.format("El vendedor con id %s no existe.", sellerId));
        }

        var seller = sellerById.get();
        var product = ProductEntity.builder()
                .name(createProductRequest.getName())
                .description(createProductRequest.getDescription())
                .category(createProductRequest.getCategory())
                .price(createProductRequest.getPrice())
                .stock(createProductRequest.getStock())
                /*.seller(SellerEntity.builder()
                        .id(seller.getId())
                        .build())*/
                .sellerId(sellerId)
                .build();

        var productCreated = createProductAdapter.create(product);

        return Product.builder()
                .id(productCreated.getId())
                .name(productCreated.getName())
                .description(productCreated.getDescription())
                .price(Price.builder().value(productCreated.getPrice()).build())
                .stock(productCreated.getStock())
                .category(createProductRequest.getCategory())
                .seller(Seller.builder()
                        .id(seller.getId())
                        .name(seller.getName())
                        .build()
                )
                .build();
    }
}
