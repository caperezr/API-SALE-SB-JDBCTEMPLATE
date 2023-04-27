package com.cperez.crudjdbc.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SaleDTO {
    private int idClient;

    private double total;
    private ArrayList<SaleDetailDTO> saleDetailsDTO;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<SaleDetailDTO> getSaleDetailsDTO() {
        return saleDetailsDTO;
    }

    public void setSaleDetailsDTO(ArrayList<SaleDetailDTO> saleDetailsDTO) {
        this.saleDetailsDTO = saleDetailsDTO;
    }
}
