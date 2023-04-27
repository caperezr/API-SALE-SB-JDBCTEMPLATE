package com.cperez.crudjdbc.repository;

import com.cperez.crudjdbc.dto.SaleDetailDTO;
import com.cperez.crudjdbc.model.Product;
import com.cperez.crudjdbc.model.SaleDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SaleDetailRepositoryTest {
    @Autowired
    SaleDetailRepository saleDetailRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    @Rollback
    public void testGetSaleDetailsBySaleId() {
        List<SaleDetail> saleDetails = saleDetailRepository.getSaleDetailsBySaleId(3);
        assertNotNull(saleDetails);
        assertEquals(2, saleDetails.size());
    }

    @Test
    @Transactional
    @Rollback
    public void testCreateSaleDetail() {
        Product product = new Product(1, "producto 1", 5);
        SaleDetailDTO saleDetailDTO = new SaleDetailDTO(product.getId(), product.getCost(), product.getDescription(), 2, 12.9);
        SaleDetail saleDetail = new SaleDetail(4, product, 3, 15 );
        SaleDetail saleDetailActual = saleDetailRepository.createSaleDetail(1, saleDetail);
        saleDetailActual.setId(jdbcTemplate.queryForObject("SELECT @max_id;", Integer.class));
        assertNotNull(saleDetailActual);
        assertEquals(saleDetail.getId(), saleDetailActual.getId());
    }

}
