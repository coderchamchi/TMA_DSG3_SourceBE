package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.entities.ShoppingCartItem;
import com.bezkoder.springjwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
    @Query(
            value = "SELECT * FROM shoppingcart_item s WHERE s.id = :id",
            nativeQuery = true)
    ArrayList<ShoppingCartItem> finditeminshoppingcart(Long id);

//    @Query(value = "INSERT INTO shoppingcart_item (user_id) VALUES (:userId)", nativeQuery = true)
//    void addItemAfterSignup(@Param("userId") Long userId);
}
