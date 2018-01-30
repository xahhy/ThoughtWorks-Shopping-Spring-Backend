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

    public float calculate(String item) {
        float value = 0;
        ArrayList<ShoppingItem> items = (ArrayList<ShoppingItem>) repository.findByBarcode(item);
        if(items.size() != 0){
            value = items.get(0).price;
        }
        return value;
    }
}
