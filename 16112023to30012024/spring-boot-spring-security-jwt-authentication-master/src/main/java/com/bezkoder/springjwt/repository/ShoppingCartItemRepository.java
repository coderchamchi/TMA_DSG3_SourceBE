package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.entities.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
    @Query(
            value = "SELECT * FROM shoppingcart_item s WHERE s.user_id = :id and product_id != 'null'",
            nativeQuery = true)
    ArrayList<ShoppingCartItem> FindAll(Long id);

}
