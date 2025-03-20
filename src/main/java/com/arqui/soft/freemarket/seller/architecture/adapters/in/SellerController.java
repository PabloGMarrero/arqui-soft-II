package com.arqui.soft.freemarket.seller.architecture.adapters.in;

import com.arqui.soft.freemarket.seller.architecture.adapters.in.request.CreateSellerRequest;
import com.arqui.soft.freemarket.seller.domain.ports.in.CreateSellerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sellers")
public class SellerController {

    private final CreateSellerPort createSellerPort;

    public SellerController(CreateSellerPort createSellerPort) {
        this.createSellerPort = createSellerPort;
    }

    @PostMapping
    public ResponseEntity<String> createSeller(@RequestBody CreateSellerRequest seller){
        return ResponseEntity.ok(seller.getName());
    }
}
