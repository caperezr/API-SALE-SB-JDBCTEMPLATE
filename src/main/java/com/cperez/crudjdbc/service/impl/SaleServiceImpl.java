package com.cperez.crudjdbc.service.impl;

import com.cperez.crudjdbc.dto.SaleDTO;
import com.cperez.crudjdbc.dto.SaleDetailDTO;
import com.cperez.crudjdbc.model.Product;
import com.cperez.crudjdbc.model.Sale;
import com.cperez.crudjdbc.model.SaleDetail;
import com.cperez.crudjdbc.repository.ClientRepository;
import com.cperez.crudjdbc.repository.ProductRepository;
import com.cperez.crudjdbc.repository.SaleDetailRepository;
import com.cperez.crudjdbc.repository.SaleRepository;
import com.cperez.crudjdbc.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleDetailRepository saleDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Sale> getSales() {
        List<Sale> sales = saleRepository.getSales();
        for (Sale sale: sales) {
            List<SaleDetail> saleDetails = saleDetailRepository.getSaleDetailsBySaleId(sale.getId());

            for (SaleDetail saleDetail : saleDetails) {

                saleDetail.setProduct(productRepository.getProcutById(saleDetail.getProduct().getId()));
            }
            sale.setSaleDetails(saleDetails);
            sale.setClient(clientRepository.getClientById(sale.getClient().getId()));
        }
        return sales;
    }

    @Override
    public Sale createSale(SaleDTO saleDTO) {
        List<SaleDetail> saleDetails = new ArrayList<>();
        for (SaleDetailDTO saleDetailDTO : saleDTO.getSaleDetailsDTO()) {
            Product product = productRepository.getProcutById(saleDetailDTO.getIdProduct());
            SaleDetail saleDetail = new SaleDetail(saleDetailDTO, product);
            saleDetails.add(saleDetail);
        }
        Sale sale = new Sale(saleDTO, saleDetails);
        sale = saleRepository.createSale(sale);

        for (SaleDetail saleDetail : saleDetails) {
            saleDetailRepository.createSaleDetail(sale.getId(), saleDetail);
        }

        sale.setSaleDetails(saleDetails);
        sale.setClient(clientRepository.getClientById(sale.getClient().getId()));

        return sale;
    }
}
