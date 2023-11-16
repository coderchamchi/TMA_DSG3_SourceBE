package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            value = "SELECT * FROM product u WHERE u.categoryid = :id",
            nativeQuery = true)
    ArrayList<Product> findProductByStatusNative(Long id);

    @Query(
            value = "SELECT * FROM product u WHERE u.productid = :id",
            nativeQuery = true)
    Optional<Product> findProductId(Long id);

    @Query("SELECT p FROM Product p WHERE p.productname LIKE CONCAT('%',:query, '%')")
    ArrayList<Product> findProductbyname(String query);

    @Query("SELECT p FROM Product p WHERE p.brand LIKE CONCAT('%',:query, '%')")
    ArrayList<Product> findProductbyBrand(String query);

    @Query("SELECT p FROM Product p JOIN Category c ON p.category.id = c.id WHERE c.categoryname LIKE CONCAT('%', :query, '%')")
    ArrayList<Product> Productbycategoryname(String query);

}

