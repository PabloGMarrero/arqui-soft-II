package com.arqui.soft.freemarket.product.domain.usecase;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.product.architecture.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.GetProductPort;
import com.arqui.soft.freemarket.product.domain.ports.out.GetProductAdapter;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductUseCase implements GetProductPort {
    private final GetProductAdapter getProductAdapter;

    public GetProductUseCase(GetProductAdapter getProductAdapter) {
        this.getProductAdapter = getProductAdapter;
    }

    @Override
    public List<Product> getProductByName(String name) {
        var products = getProductAdapter.getProductByName(name);

        return mapProductsToModel(products);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        var products = getProductAdapter.getProductByCategory(category);

        return mapProductsToModel(products);
    }

    private static List<Product> mapProductsToModel(List<ProductEntity> products) {
        return products.stream().map(product -> Product.builder()
                        .id(product.getId())
                        .stock(product.getStock())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(Price.builder()
                                .value(product.getPrice())
                                .build()
                        )
                        .seller(Seller.builder()
                                .id(product.getSellerId())
                                .build()
                        )
                        .category(product.getCategory())
                        .build())
                .toList();
    }
}
