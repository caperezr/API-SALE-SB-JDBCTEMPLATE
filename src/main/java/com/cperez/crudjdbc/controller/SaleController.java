package com.cperez.crudjdbc.controller;

import com.cperez.crudjdbc.dto.SaleDTO;
import com.cperez.crudjdbc.model.Sale;
import com.cperez.crudjdbc.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class SaleController {


    @Autowired
    private SaleService saleService;

    @PostMapping("/sales")
    @Transactional
    public ResponseEntity<Sale> saveSale(@RequestBody SaleDTO saleDTO) {
        try {
            Sale sale = saleService.createSale(saleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(sale);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> getSales() {
        try {
            List<Sale> sales = saleService.getSales();
            return ResponseEntity.status(HttpStatus.OK).body(sales);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /*@GetMapping("/saleDetail/{idCliente}")
    public ResponseEntity<List<SaleDetail>> getSaleDetails(@PathVariable int idCliente) {
        try {
            List<SaleDetail> saleDetail = saleRepository.getSaleDetails(idCliente);
            return ResponseEntity.status(HttpStatus.OK).body(saleDetail);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }*/

    /*@GetMapping("/saleDetailBy/{idCliente}")
    public ResponseEntity<ListSalesDTO> getListSaleDetailsDTO(@PathVariable int idCliente) {
        try {
            ListSalesDTO listSalesDTO = saleRepository.getListSalesDTO(idCliente);
            return ResponseEntity.status(HttpStatus.OK).body(listSalesDTO);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }*/


}
