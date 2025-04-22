package com.arqui.soft.freemarket.sales.architecture.adapters.in;

import com.arqui.soft.freemarket.commons.exceptions.ProcessSaleException;
import com.arqui.soft.freemarket.commons.exceptions.ProductDoestNotExistException;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.sales.architecture.adapters.in.request.SaleRequest;
import com.arqui.soft.freemarket.sales.architecture.adapters.in.response.SaleResponse;
import com.arqui.soft.freemarket.sales.domain.ports.in.ProcessSalePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {

    private final ProcessSalePort processSalePort;

    public SaleController(ProcessSalePort processSalePort) {
        this.processSalePort = processSalePort;
    }


    @PostMapping
    public ResponseEntity<SaleResponse> createUser(@RequestBody SaleRequest sale) throws ProductDoestNotExistException, ProcessSaleException, SellerDoesNotExistException {
        return ResponseEntity.ok(processSalePort.process(sale));
    }
}
