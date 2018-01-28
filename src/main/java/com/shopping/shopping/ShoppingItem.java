package com.shopping.shopping;

public class ShoppingItem {
    private final String barcode;
    private final String name;
    private final float price;
    private final String unit;

    public ShoppingItem(String barcode, String name, float price, String unit) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}
