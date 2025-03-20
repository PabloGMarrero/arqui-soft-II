package com.arqui.soft.freemarket.product.architecture.adapters.in;

import com.arqui.soft.freemarket.product.domain.ports.in.DeleteProductPort;
import com.arqui.soft.freemarket.product.domain.ports.in.GetProductPort;
import com.arqui.soft.freemarket.product.domain.ports.in.UpdateProductPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final GetProductPort getProductPort;
    private final DeleteProductPort deleteProductPort;
    private final UpdateProductPort updateProductPort;

    public ProductController(GetProductPort getProductPort, DeleteProductPort deleteProductPort, UpdateProductPort updateProductPort) {
        this.getProductPort = getProductPort;
        this.deleteProductPort = deleteProductPort;
        this.updateProductPort = updateProductPort;
    }

    @GetMapping(path = "/byName/{name}")
    public ResponseEntity<String> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(name);
    }

    @GetMapping(path = "/byCategory/{category}")
    public ResponseEntity<String> getProductByCategory(@PathVariable String category){
        return ResponseEntity.ok(category);
    }
}
