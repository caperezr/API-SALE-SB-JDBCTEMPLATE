package com.cperez.crudjdbc.repository;

import com.cperez.crudjdbc.dto.ProductDTO;
import com.cperez.crudjdbc.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    @Transactional
    @Rollback
    public void testGetProducts() {
        List<Product> products = productRepository.getProducts();
        assertNotNull(products);
        assertEquals(4, products.size());
    }
    @Test
    @Transactional
    @Rollback
    public void testGetProductById() {
        Product productPrueba = new Product(1, "producto 1",5);
        Product productActual = productRepository.getProcutById(1);
        assertNotNull(productActual);
        assertEquals(productPrueba.getId(), productActual.getId());
        assertEquals(productPrueba.getDescription(), productActual.getDescription());
        assertEquals(productPrueba.getCost(), productActual.getCost());
    }

    @Test
    @Transactional
    @Rollback
    public void testCreateProduct() {
        ProductDTO productDTO = new ProductDTO("Mandarina", 1.90);
        ProductDTO result = productRepository.createProduct(productDTO);
        assertNotNull(result);
        assertEquals(productDTO, result);
    }

}
