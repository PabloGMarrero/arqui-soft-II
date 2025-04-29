package com.arqui.soft.freemarket.product.infrastructure.adapters.in;

import com.arqui.soft.freemarket.commons.exceptions.FilterIsNotAllowedException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidFilterParameter;
import com.arqui.soft.freemarket.commons.exceptions.ProductDoestNotExistException;
import com.arqui.soft.freemarket.product.infrastructure.adapters.in.request.CreateProductRequest;
import com.arqui.soft.freemarket.product.infrastructure.adapters.in.request.UpdateProductRequest;
import com.arqui.soft.freemarket.commons.exceptions.SellerDoesNotExistException;
import com.arqui.soft.freemarket.product.domain.model.Product;
import com.arqui.soft.freemarket.product.domain.ports.in.CreateProductPort;
import com.arqui.soft.freemarket.product.domain.ports.in.DeleteProductPort;
import com.arqui.soft.freemarket.product.domain.ports.in.GetProductPort;
import com.arqui.soft.freemarket.product.domain.ports.in.UpdateProductPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final GetProductPort getProductPort;
    private final CreateProductPort createProductPort;
    private final DeleteProductPort deleteProductPort;
    private final UpdateProductPort updateProductPort;

    public ProductController(GetProductPort getProductPort, CreateProductPort createProductPort, DeleteProductPort deleteProductPort, UpdateProductPort updateProductPort) {
        this.getProductPort = getProductPort;
        this.createProductPort = createProductPort;
        this.deleteProductPort = deleteProductPort;
        this.updateProductPort = updateProductPort;
    }

    @GetMapping(path = "/byName/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(getProductPort.getProductByName(name));
    }

    @GetMapping(path = "/byCategory/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
        return ResponseEntity.ok(getProductPort.getProductByCategory(category));
    }

    @PostMapping(path = "/{sellerId}")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest createProductRequest, @PathVariable String sellerId) throws SellerDoesNotExistException {
        return ResponseEntity.ok(createProductPort.create(createProductRequest, sellerId));
    }

    @PatchMapping(path = "/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequest productRequest) throws ProductDoestNotExistException {
        return ResponseEntity.ok(updateProductPort.update(productId, productRequest));
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId){
        deleteProductPort.delete(productId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam(required = false) String filterType,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) BigDecimal price) throws FilterIsNotAllowedException, InvalidFilterParameter {
        return ResponseEntity.ok(getProductPort.filter(filterType, minPrice, maxPrice, price));
    }

}
