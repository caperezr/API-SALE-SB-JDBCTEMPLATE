package com.cperez.crudjdbc.controller;


import com.cperez.crudjdbc.dto.ProductDTO;

import com.cperez.crudjdbc.model.Product;

import com.cperez.crudjdbc.repository.ProductRepository;

import com.cperez.crudjdbc.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        try {
            List<Product> products = productService.getProducts();
            return ResponseEntity.status(HttpStatus.OK).body(products);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        try {
            Product product = productService.getProcutById(id);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/products")
    @Transactional
    public ResponseEntity<ProductDTO> createClient(@RequestBody ProductDTO productDTO) {
        try {
            ProductDTO productSave = productService.createProduct(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productSave);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
