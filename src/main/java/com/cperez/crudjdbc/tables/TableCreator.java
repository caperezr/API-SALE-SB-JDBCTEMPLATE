package com.cperez.crudjdbc.tables;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableCreator {
    private JdbcTemplate jdbcTemplate;

    public TableCreator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void crearTablaCient() {
        String sql = "CREATE TABLE IF NOT EXISTS CLIENT " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " name VARCHAR(255), " +
                " phone VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        jdbcTemplate.execute(sql);
    }

    public void crearTablaSale() {
        String sql = "CREATE TABLE IF NOT EXISTS SALE " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " idClient INTEGER not NULL, " +
                " total DECIMAL(19,2), " +
                " PRIMARY KEY ( id ), " +
                " FOREIGN KEY (idClient) REFERENCES CLIENT(id))";
        jdbcTemplate.execute(sql);
    }

    public void crearTablaProduct() {
        String sql = "CREATE TABLE IF NOT EXISTS PRODUCT " +
                "(id INT AUTO_INCREMENT PRIMARY KEY," +
                "  description VARCHAR(255)," +
                "  cost DECIMAL(19,2));";
        jdbcTemplate.execute(sql);
    }

    public void crearTablaSaleDetail() {
        String sql = "CREATE TABLE IF NOT EXISTS SALEDETAIL " +
                "(id INT AUTO_INCREMENT PRIMARY KEY," +
                "  idSale INT NOT NULL," +
                "  idProduct INT NOT NULL," +
                "  quantity INT," +
                "  subtotal DECIMAL(19,2)," +
                "  FOREIGN KEY (idSale) REFERENCES SALE(id)," +
                "  FOREIGN KEY (idProduct) REFERENCES PRODUCT(id));";
        jdbcTemplate.execute(sql);
    }






}
