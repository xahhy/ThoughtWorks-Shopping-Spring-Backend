package com.shopping.shopping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ShoppingItem {

    private @Id @GeneratedValue Long id;
    private String barcode;
    private String name;
    private float price;
    private String unit;

    private ShoppingItem(){}

    public ShoppingItem(String barcode, String name, float price, String unit) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }
}
