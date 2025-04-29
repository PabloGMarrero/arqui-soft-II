package com.arqui.soft.freemarket.product.infrastructure.adapters.in;

import com.arqui.soft.freemarket.commons.Price;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductEntity;
import com.arqui.soft.freemarket.product.infrastructure.adapters.out.ProductMapperAdapter;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper implements ProductMapperAdapter {
    @Override
    public List<Product> mapProductsToModel(List<ProductEntity> products) {
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
