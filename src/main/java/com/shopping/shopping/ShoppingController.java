package com.shopping.shopping;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
public class ShoppingController {
    //    @Autowired
//    private ShoppingItemRepository repository;
//
//
//    @RequestMapping("/items")
//    public List<ShoppingItem> getShoppingItems(){
//        return (List<ShoppingItem>) this.repository.findAll();
//    }
    @Autowired
    private ShoppingItemRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity getClientItems(@RequestBody List<String> items) throws Exception {
        for (String item : items) {
            CalculateItem item_calculator = new CalculateItem(repository);
            float result = item_calculator.calculate(item);
        }
        return ResponseEntity.ok(JSONArray.toJSONString(items));
    }
}
