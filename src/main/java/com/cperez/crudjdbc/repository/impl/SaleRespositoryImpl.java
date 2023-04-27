package com.cperez.crudjdbc.repository.impl;

import com.cperez.crudjdbc.model.Client;
import com.cperez.crudjdbc.model.Sale;
import com.cperez.crudjdbc.repository.ProductRepository;
import com.cperez.crudjdbc.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class SaleRespositoryImpl implements SaleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@Override
    public SaleDTO saveSale(SaleDTO saleDTO) {
        double total = 0, subtotal;

        String sqlSale = "INSERT INTO SALE (IDCLIENT, TOTAL) VALUES (?,?) ";
        jdbcTemplate.update(sqlSale, saleDTO.getIdClient(), total);

        int idSale = jdbcTemplate.queryForObject("SELECT MAX(id) FROM SALE;", Integer.class);

        System.out.println(productRepository.getProcutById(1).getCost()+"");

        ArrayList<SaleDetailDTO> saleDetails = saleDTO.getSaleDetailsDTO();

        for (SaleDetailDTO saleDetail : saleDetails) {
            System.out.println(saleDetail.getIdProduct()+"");
            System.out.println(idSale+"");
            int idProduct = saleDetail.getIdProduct();
            productRepository.getProcutById(idProduct);
            double cost = productRepository.getProcutById(idProduct).getCost();
            int quantity = saleDetail.getQuantity();
            subtotal = cost * quantity;
            String sqlSaleDetail = "INSERT INTO SALEDETAIL (IDSALE, IDPRODUCT, QUANTITY, SUBTOTAL) VALUES (?,?,?,?) ";
            jdbcTemplate.update(sqlSaleDetail, idSale, idProduct, quantity, subtotal);
            total = total + subtotal;
        }

        String sqlUpdateTotal = "UPDATE SALE SET TOTAL = ? WHERE ID = ? ";
        jdbcTemplate.update(sqlUpdateTotal, total, idSale);

        return saleDTO;
    }*/

    @Override
    public List<Sale> getSales() {
        String sql = "SELECT * FROM SALE";
        List<Sale> sales = jdbcTemplate.query(sql, (rs, rowNum) -> mapToSale(rs));
        return sales;
    }

    private Sale mapToSale(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        double total = rs.getDouble("total");
        int clientId = rs.getInt("idClient");
        Client client = new Client();
        client.setId(clientId);
        Sale sale = new Sale();
        sale.setId(id);
        sale.setTotal(total);
        sale.setClient(client);
        return sale;
    }


    @Override
    public Sale createSale(Sale sale) {
        SimpleJdbcInsert simpleJdbcInsert =
                new SimpleJdbcInsert(jdbcTemplate.getDataSource())
                        .withTableName("SALE")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idClient", sale.getClient().getId());
        parameters.put("total", sale.getTotal());
        int id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        sale.setId(id);
        return sale;
    }


}
