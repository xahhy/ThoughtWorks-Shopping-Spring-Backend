package com.shopping.shopping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuyingItem extends ShoppingItem {
    public int count;

    public BuyingItem() {
        super();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                "barcode=" + this.barcode +
                "price=" + this.price +
                "unit=" + this.unit +
                "}";

    }
//    public BuyingItem(String barcode, String name, float price, String unit) {
//        super(barcode, name, price, unit);
//        this.count = count;
//    }
}
