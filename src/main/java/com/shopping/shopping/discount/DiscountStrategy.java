package com.shopping.shopping.discount;

import com.shopping.shopping.BuyingItem;
import com.shopping.shopping.ShoppingItem;

import java.util.List;

public interface DiscountStrategy {
    String type = null;
    List<String> barcodes = null;
    float discount();
}
