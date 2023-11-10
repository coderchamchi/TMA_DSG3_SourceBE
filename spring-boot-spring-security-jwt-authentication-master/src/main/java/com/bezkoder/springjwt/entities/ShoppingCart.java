//package com.bezkoder.springjwt.entities;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.*;
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "shopping_cart")
//public class ShoppingCart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "shopping_cart_id")
//    private Long id;
//
//    private int totalItems;
//
//    private double totalPrices;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "Userid", referencedColumnName = "Userid")
//    private User customer;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
//    private Set<CartItem> cartItem;
//}