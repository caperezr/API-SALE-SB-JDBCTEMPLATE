package com.cperez.crudjdbc.tables;

import org.springframework.jdbc.core.JdbcTemplate;

public class StoredProcedure {
    private JdbcTemplate jdbcTemplate;

    public StoredProcedure(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void procedureGetClients() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS getClients;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE getClients()\n" +
                "BEGIN\n" +
                "   SELECT * FROM CLIENT;\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void procedureGetClientById() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS getClientById;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE getClientById(IN clientId INT)\n" +
                "BEGIN\n" +
                "   SELECT * FROM CLIENT WHERE id = clientId;\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void procedureCreateClient() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS insertClient;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE insertClient(IN clientName VARCHAR(255), IN clientPhone VARCHAR(255))\n" +
                "BEGIN\n" +
                "   INSERT INTO CLIENT (NAME, PHONE) VALUES (clientName, clientPhone);\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void procedureGetProducts() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS getProducts;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE getProducts()\n" +
                "BEGIN\n" +
                "   SELECT * FROM PRODUCT;\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void procedureGetProcutById() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS getProductById;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE getProductById(IN productId INT)\n" +
                "BEGIN\n" +
                "   SELECT * FROM PRODUCT WHERE id = productId;\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void procedureCreateProduct() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS insertProduct;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE insertProduct(IN desProd VARCHAR(255), IN costPro DECIMAL(19,2))\n" +
                "BEGIN\n" +
                "   INSERT INTO PRODUCT (description, cost) VALUES (desProd,costPro);\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void procedureGetSaleDetailByIdSale() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS getSaleDetailByIdSale;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE getSaleDetailByIdSale(IN idSaleIn INT)\n" +
                "BEGIN\n" +
                "   SELECT * FROM SALEDETAIL WHERE idSale = idSaleIn;\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void procedureCreateSaleDetail() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS insertSaleDetail;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE insertSaleDetail(IN idSale INT, IN idProduct INT, IN quantity INT, IN subtotal DOUBLE)\n" +
                "BEGIN\n" +
                "   INSERT INTO SALEDETAIL (IDSALE, IDPRODUCT, QUANTITY, SUBTOTAL) VALUES (idSale, idProduct, quantity, subtotal);\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }

    public void triggerMaxId() {
        String createTriggerSql = "CREATE TRIGGER trigger_max_id\n" +
                "AFTER INSERT ON SALEDETAIL\n" +
                "FOR EACH ROW\n" +
                "BEGIN\n" +
                "   SET @max_id = (SELECT MAX(id) FROM SALEDETAIL);\n" +
                "END;";
        jdbcTemplate.execute(createTriggerSql);
    }



    /*public void crearProcedureCreateClient() {
        String dropProcedure = "DROP PROCEDURE IF EXISTS createClients;";
        jdbcTemplate.execute(dropProcedure);
        String createProcedureSql = "CREATE PROCEDURE getClients()\n" +
                "BEGIN\n" +
                "   SELECT * FROM CLIENT;\n" +
                "END;";
        jdbcTemplate.execute(createProcedureSql);
    }*/




}
