package com.cperez.crudjdbc.service;

import com.cperez.crudjdbc.dto.SaleDTO;
import com.cperez.crudjdbc.model.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {
    public List<Sale> getSales();
    public Sale createSale(SaleDTO saleDTO);
}
