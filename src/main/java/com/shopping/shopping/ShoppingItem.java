package com.shopping.shopping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ShoppingItem {

    protected @Id
    @GeneratedValue
    Long id;
    protected String barcode;
    protected String name;
    protected float price;
    protected String unit;

    protected ShoppingItem() {
    }

    public ShoppingItem(String barcode, String name, float price, String unit) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }
}
