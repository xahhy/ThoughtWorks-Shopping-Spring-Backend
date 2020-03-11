package com.shopping.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

public class CalculateItem {
    private ShoppingItemRepository repository;

    public CalculateItem(ShoppingItemRepository repository){
        this.repository = repository;
    }

    public float calculate(String itemString) throws Exception {
        float value = 0;
        String barcode = getItemBarcode(itemString);
        float count = getItemCount(itemString);
        ShoppingItem item = repository.findByBarcode(barcode);
        if (item == null)throw new Exception(String.format("Cannot find %s in database", barcode));
        value = item.price * count;
        return value;
    }

    public static float getItemCount(String item){
        try {
            String count_string = item.split("-")[1];
            return Float.parseFloat(count_string);
        }catch (Exception e){
            return 1f;
        }
    }

    public static String getItemBarcode(String item){
        try {
            String barcode = item.split("-")[0];
            return barcode;
        }catch (Exception e){
            return "Error getItemBarcode";
        }
    }
}
