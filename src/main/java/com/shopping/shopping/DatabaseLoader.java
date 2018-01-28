package com.shopping.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ShoppingItemRepository repository;

    @Autowired
    public DatabaseLoader(ShoppingItemRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception{
        this.repository.save(new ShoppingItem("ITEM0", "可乐", 1.0f, "瓶"));
    }
}
