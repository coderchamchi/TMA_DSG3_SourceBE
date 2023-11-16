//package com.bezkoder.springjwt.controllers;
//
//import com.bezkoder.springjwt.Service.ShoppingCartService;
//import com.bezkoder.springjwt.entities.Product;
//import com.bezkoder.springjwt.entities.ShoppingCart;
//import com.bezkoder.springjwt.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("ProjectSJ/Cart")
//public class CartController {
//    @Autowired
//    ShoppingCartService shoppingCartService;
//    @GetMapping("/all")
//
//    public ResponseEntity<List<ShoppingCart>> getallCart() {
//        List<ShoppingCart> listcart = shoppingCartService.getallCart();
//        return new ResponseEntity<List<ShoppingCart>>(listcart, HttpStatus.OK);
//    }
//    @GetMapping("/add")
//
//    public ResponseEntity<ShoppingCart> addCart(Product product, int quantity, User customer) {
//        ShoppingCart cart = shoppingCartService.addItemToCart(product, quantity, customer);
//        return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
//    }
//}
