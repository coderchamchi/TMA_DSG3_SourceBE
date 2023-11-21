package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.ShoppingCartSItemervice;

import com.bezkoder.springjwt.Service.UserService;
import com.bezkoder.springjwt.constant.WebUnit;
import com.bezkoder.springjwt.dto.ResponseJson;
import com.bezkoder.springjwt.dto.itemDTO;
import com.bezkoder.springjwt.entities.Product;

import com.bezkoder.springjwt.entities.ShoppingCartItem;
import com.bezkoder.springjwt.entities.User;
import com.bezkoder.springjwt.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
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
        Long userId =  user.getId();
        List<ShoppingCartItem> listcart = shoppingCartService.getallCart(userId);
        return new ResponseEntity<List<ShoppingCartItem>>(listcart, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseJson<Boolean>> addCart(@Validated @RequestBody  itemDTO itemDTO) {
        if (ObjectUtils.isEmpty(itemDTO)){
            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "Not Found Product and Quantity"));
        }
        try {
            User user = userService.findUserByUserName();
            if (ObjectUtils.isEmpty(user)){
                return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "User Not Found"));
            }
            boolean check = shoppingCartService.addItemToCart(itemDTO, user);
                if (!check)
                {
                    return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "User Not Found"));
                }
                return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Created a shopping cart for user: "+ user.getEmail()));
        }
        catch (Exception e){
            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "User Not Found"));
        }
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
