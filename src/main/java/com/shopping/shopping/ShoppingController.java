package com.shopping.shopping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingController {

    @RequestMapping("/items")
    public List<ShoppingItem> getShoppingItems(){
        List<ShoppingItem> itemList = new ArrayList<>();
        itemList.add(new ShoppingItem("ITEM0", "可乐", (float) 1.0, "瓶"));
        return itemList;

    }
}
