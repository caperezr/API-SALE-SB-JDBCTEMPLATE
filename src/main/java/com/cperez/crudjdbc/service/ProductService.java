package com.cperez.crudjdbc.service;

import com.cperez.crudjdbc.dto.ProductDTO;
import com.cperez.crudjdbc.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getProducts();
    public Product getProcutById (int id);
    public ProductDTO createProduct (ProductDTO productDTO);
}
