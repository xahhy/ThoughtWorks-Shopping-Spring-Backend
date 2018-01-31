package com.shopping.shopping.discount;

import com.shopping.shopping.BuyingItem;
import com.shopping.shopping.ShoppingItem;

public class BuyTwoOneFreeDiscount implements DiscountStrategy {
    private final String type  = "BUY_TWO_GET_ONE_FREE";
    public float count = 0;
    public ShoppingItem item = null;

    public BuyTwoOneFreeDiscount(ShoppingItem item, float count){
        this.count = count;
        this.item = item;
    }

    @Override
    public float discount() {
        int free_count = (int)count / 3;
        return free_count * item.getPrice();
    }
}
