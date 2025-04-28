package com.arqui.soft.freemarket.seller.architecture.adapters.in;

import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.commons.exceptions.UserDoestNotExistException;
import com.arqui.soft.freemarket.seller.architecture.adapters.in.request.CreateSellerRequest;
import com.arqui.soft.freemarket.seller.architecture.adapters.in.request.UpdateSellerRequest;
import com.arqui.soft.freemarket.seller.domain.model.Seller;
import com.arqui.soft.freemarket.seller.domain.ports.in.CreateSellerPort;
import com.arqui.soft.freemarket.seller.domain.ports.in.DeleteSellerPort;
import com.arqui.soft.freemarket.seller.domain.ports.in.UpdateSellerPort;
import com.arqui.soft.freemarket.seller.domain.ports.out.DeleteSellerAdapter;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.in.UpdateUserPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sellers")
public class SellerController {

    private final CreateSellerPort createSellerPort;
    private final UpdateSellerPort updateSellerPort;
    private final DeleteSellerPort deleteSellerPort;

    public SellerController(CreateSellerPort createSellerPort, UpdateSellerPort updateSellerPort, DeleteSellerPort deleteSellerPort) {
        this.createSellerPort = createSellerPort;
        this.updateSellerPort = updateSellerPort;
        this.deleteSellerPort = deleteSellerPort;
    }

    @PostMapping
    public ResponseEntity<Seller> createSeller(@RequestBody CreateSellerRequest seller) throws InvalidEmailException, EmailAlreadyExistException {
        return ResponseEntity.ok(createSellerPort.create(seller));
    }

    @PatchMapping(path = "/{sellerId}")
    public ResponseEntity<Seller> updateSeller(@PathVariable String sellerId, @RequestBody UpdateSellerRequest sellerRequest) throws SellerDoesNotExistException {
        return ResponseEntity.ok(updateSellerPort.update(sellerId, sellerRequest));
    }

    @DeleteMapping(path = "/{sellerId}")
    public ResponseEntity<String> deleteSeller(@PathVariable String sellerId){
        deleteSellerPort.delete(sellerId);
        return ResponseEntity.accepted().build();
    }
}
