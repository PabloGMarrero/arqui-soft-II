package com.arqui.soft.freemarket.seller.infrastructure.adapters.in.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateSellerRequest {
    private String name;
    private String email;
}
