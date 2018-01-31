package com.shopping.shopping;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    ShoppingItem findByBarcode(@Param("barcode") String barcode);
}
