package com.cperez.crudjdbc.model;

import com.cperez.crudjdbc.dto.SaleDTO;
import com.cperez.crudjdbc.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private int id;
    private Client client;
    private double total;

    private List<SaleDetail> saleDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Sale(SaleDTO saleDTO, List<SaleDetail> saleDetails) {
        Client client = new Client();
        client.setId(saleDTO.getIdClient());
        this.client = client;
        double total = 0.0;
        for (int i = 0; i < saleDetails.size(); i++) {
            total += saleDTO.getSaleDetailsDTO().get(i).getQuantity() * saleDetails.get(i).getProduct().getCost();
        }
        this.total = total;
    }
}
