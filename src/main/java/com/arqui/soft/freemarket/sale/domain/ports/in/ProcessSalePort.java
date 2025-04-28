package com.arqui.soft.freemarket.sale.domain.ports.in;

import com.arqui.soft.freemarket.commons.exceptions.ProcessSaleException;
import com.arqui.soft.freemarket.commons.exceptions.ProductDoestNotExistException;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.sale.architecture.adapters.in.request.SaleRequest;
import com.arqui.soft.freemarket.sale.architecture.adapters.in.response.SaleResponse;

public interface ProcessSalePort {
    SaleResponse process(SaleRequest sale) throws ProductDoestNotExistException, SellerDoesNotExistException, ProcessSaleException;
}
