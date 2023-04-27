package com.cperez.crudjdbc.repository;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.dto.ProductDTO;
import com.cperez.crudjdbc.model.Client;
import com.cperez.crudjdbc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    public List<Product> getProducts();
    public Product getProcutById (int id);
    public ProductDTO createProduct (ProductDTO productDTO);
}
