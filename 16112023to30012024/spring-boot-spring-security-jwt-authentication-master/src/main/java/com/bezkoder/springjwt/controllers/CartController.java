package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.ShoppingCartSItemervice;

import com.bezkoder.springjwt.Service.UserService;
import com.bezkoder.springjwt.constant.WebUnit;
import com.bezkoder.springjwt.dto.ResponseJson;
import com.bezkoder.springjwt.entities.Product;

import com.bezkoder.springjwt.entities.ShoppingCartItem;
import com.bezkoder.springjwt.entities.User;
import com.bezkoder.springjwt.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ProjectSJ/shoppingCartItem")
public class CartController {
    @Autowired
    ShoppingCartSItemervice shoppingCartService;

    @Autowired
    UserService userService;

    @GetMapping("/all")

    public ResponseEntity<List<ShoppingCartItem>> getallCart() {
        User user = userService.findUserByUserName();
        Long id =  user.getId();
        List<ShoppingCartItem> listcart = shoppingCartService.getallCart(id);
        return new ResponseEntity<List<ShoppingCartItem>>(listcart, HttpStatus.OK);
    }
    @GetMapping("/add")

    public ResponseEntity<ShoppingCartItem> addCart(Product product, int quantity, User customer) {
        return null;
//        ShoppingCartSItemervice shoppingCartSItemervice = shoppingCartService.addItemToCart(product, quantity, customer);
//        return new ResponseEntity<ShoppingCartItem>(ShoppingCartItem, HttpStatus.OK);
    }
    @PostMapping("/aftersignup")
    public ResponseEntity<ResponseJson<Boolean>> Shoppingcartaftersignup() {
        try {
            User user = userService.findUserByUserName();
            boolean check = shoppingCartService.Shoppingcartaftersignup(user);
            if (!check){
                return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "User Not Found"));
            }
            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Created a shopping cart for user: "+ user.getEmail()));
        }
        catch (Exception e){
            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "User Not Found"));
        }
    }

}
