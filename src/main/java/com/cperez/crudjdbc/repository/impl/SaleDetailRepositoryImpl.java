package com.cperez.crudjdbc.repository.impl;

import com.cperez.crudjdbc.model.Product;
import com.cperez.crudjdbc.model.SaleDetail;
import com.cperez.crudjdbc.repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SaleDetailRepositoryImpl implements SaleDetailRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<SaleDetail> getSaleDetailsBySaleId(int saleId) {
        String sql = "CALL getSaleDetailByIdSale(?)";
        //String sql = "SELECT * FROM SALEDETAIL WHERE idSale = ?;";
        List<SaleDetail> listSaleDetails = jdbcTemplate.query(sql,
                (rs, rowNum) -> mapToSaleDetail(rs), saleId);
        return listSaleDetails;
    }

    private SaleDetail mapToSaleDetail(ResultSet rs) throws SQLException {
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setId(rs.getInt("id"));
        Product product = new Product();
        product.setId(rs.getInt("idProduct"));
        saleDetail.setQuantity(rs.getInt("quantity"));
        saleDetail.setSubtotal(rs.getDouble("subtotal"));
        saleDetail.setProduct(product);
        return saleDetail;
    }

    @Override
    public SaleDetail createSaleDetail(int saleId, SaleDetail saleDetail) {
        String sqlSaleDetail = "CALL insertSaleDetail(?,?,?,?);";
        jdbcTemplate.update(sqlSaleDetail, saleId , saleDetail.getProduct().getId(), saleDetail.getQuantity(), saleDetail.getSubtotal());
        int id = jdbcTemplate.queryForObject("SELECT @max_id;", Integer.class);
        saleDetail.setId(id);
        return saleDetail;
    }
}
