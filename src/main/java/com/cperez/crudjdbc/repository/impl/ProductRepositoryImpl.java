package com.cperez.crudjdbc.repository.impl;

import com.cperez.crudjdbc.dto.ProductDTO;
import com.cperez.crudjdbc.model.Client;
import com.cperez.crudjdbc.model.Product;
import com.cperez.crudjdbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getProducts() {
        String sql = "CALL getProducts();";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public Product getProcutById(int id) {
        String sql = "CALL getProductById(?);";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        String sql = "CALL insertProduct(?,?);";
        jdbcTemplate.update(sql, productDTO.getDescription(), productDTO.getCost());
        return productDTO;
    }
}
