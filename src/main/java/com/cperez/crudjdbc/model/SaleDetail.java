package com.cperez.crudjdbc.model;

import com.cperez.crudjdbc.dto.SaleDetailDTO;
import com.cperez.crudjdbc.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail {
    private int id;
    private Product product;
    private int quantity;
    private double subtotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public SaleDetail(SaleDetailDTO saleDetailDTO, Product product) {
        this.product = product;
        this.quantity = saleDetailDTO.getQuantity();
        this.subtotal = saleDetailDTO.getQuantity()*product.getCost();
    }

}
