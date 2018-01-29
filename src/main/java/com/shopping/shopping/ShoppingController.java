package com.shopping.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody String item) {
        return ResponseEntity.ok(item);
    }
}
