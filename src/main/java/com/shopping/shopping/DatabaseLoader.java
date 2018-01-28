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
        this.repository.save(new ShoppingItem("ITEM000000", "可口可乐", 3.00f, "瓶"));
        this.repository.save(new ShoppingItem("ITEM000001", "雪碧", 3.00f, "瓶"));
        this.repository.save(new ShoppingItem("ITEM000002", "苹果", 5.50f, "斤"));
        this.repository.save(new ShoppingItem("ITEM000003", "荔枝", 15.00f, "斤"));
        this.repository.save(new ShoppingItem("ITEM000004", "电池", 12.00f, "个"));
        this.repository.save(new ShoppingItem("ITEM000005", "方便面", 4.50f, "袋"));
    }
}
