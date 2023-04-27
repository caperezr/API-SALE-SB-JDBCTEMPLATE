package com.cperez.crudjdbc.repository;

import com.cperez.crudjdbc.model.SaleDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailRepository {
    public List<SaleDetail> getSaleDetailsBySaleId(int saleId);
    public SaleDetail createSaleDetail(int saleId, SaleDetail saleDetail);
}
