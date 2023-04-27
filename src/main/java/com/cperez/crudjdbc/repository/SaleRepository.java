package com.cperez.crudjdbc.repository;

import com.cperez.crudjdbc.model.Sale;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository {
    public List<Sale> getSales();
    public Sale createSale(Sale sale);
}
