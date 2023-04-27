package com.cperez.crudjdbc.service.impl;

import com.cperez.crudjdbc.dto.ProductDTO;
import com.cperez.crudjdbc.model.Product;
import com.cperez.crudjdbc.repository.ProductRepository;
import com.cperez.crudjdbc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product getProcutById(int id) {
        return productRepository.getProcutById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return productRepository.createProduct(productDTO);
    }
}
