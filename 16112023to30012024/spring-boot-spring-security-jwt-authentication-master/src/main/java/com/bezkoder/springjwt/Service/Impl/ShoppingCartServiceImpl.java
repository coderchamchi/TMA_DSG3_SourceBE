package com.bezkoder.springjwt.Service.Impl;

import com.bezkoder.springjwt.Service.ShoppingCartSItemervice;
import com.bezkoder.springjwt.Service.UserService;
import com.bezkoder.springjwt.constant.WebUnit;
import com.bezkoder.springjwt.entities.Product;
import com.bezkoder.springjwt.entities.ShoppingCartItem;
import com.bezkoder.springjwt.entities.User;
import com.bezkoder.springjwt.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartSItemervice {
    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    UserService userService;

    @Override
    public List<ShoppingCartItem> getallCart(Long id) {
        return shoppingCartItemRepository.finditeminshoppingcart(id);
    }

    @Override
    public boolean Shoppingcartaftersignup(User user) {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        if (ObjectUtils.isEmpty(user)){
            return false;
        }
        shoppingCartItem.setUser(user);
        shoppingCartItemRepository.save(shoppingCartItem);
        return true;
    }

    @Override
    public ShoppingCartItem addItemToCart(Product product, int quantity, User Customer) {
        return null;
    }

    @Override
    public ShoppingCartItem updateItemInCart(Product product, int quantity, User customer) {
        return null;
    }

    @Override
    public ShoppingCartItem deleteItemFromCart(Product product, User customer) {
        return null;
    }

    @Override
    public ShoppingCartItem findCartItem(Set<Product> cartItems, Long productId) {
        return null;
    }

//    @Override
//    public ShoppingCart addItemToCart(Product product, int quantity, User customer) {
//        ShoppingCart cart = customer.getShoppingCart();
//
//        if (cart == null) {
//            cart = new ShoppingCart();
//        }
//        Set<CartItem> cartItems = cart.getCartItem();
//        CartItem cartItem = findCartItem(cartItems, product.getProductid());
//        if (cartItems == null) {
//            cartItems = new HashSet<>();
//            if (cartItem == null) {
//                cartItem = new CartItem();
//                cartItem.setProduct(product);
//                cartItem.setTotalPrice(quantity * product.getPrice());
//                cartItem.setQuantity(quantity);
//                cartItem.setCart(cart);
//                cartItems.add(cartItem);
//                itemRepository.save(cartItem);
//            }
//        }
//        else {
//            if (cartItem == null) {
//                cartItem = new CartItem();
//                cartItem.setProduct(product);
//                cartItem.setTotalPrice(quantity * product.getPrice());
//                cartItem.setQuantity(quantity);
//                cartItem.setCart(cart);
//                cartItems.add(cartItem);
//                itemRepository.save(cartItem);
//            }
//            else
//            {
//                cartItem.setQuantity(cartItem.getQuantity() + quantity);
//                cartItem.setTotalPrice(cartItem.getTotalPrice() + ( quantity * product.getPrice()));
//                itemRepository.save(cartItem);
//            }
//        }
//        cart.setCartItem(cartItems);
//
//        int totalItems = totalItems(cart.getCartItem());
//        double totalPrice = totalPrice(cart.getCartItem());
//
//        cart.setTotalPrices(totalPrice);
//        cart.setTotalItems(totalItems);
//        cart.setCustomer(customer);
//
//        return cartRepository.save(cart);
//    }
//
//    @Override
//    public ShoppingCart updateItemInCart(Product product, int quantity, User customer) {
//        ShoppingCart cart = customer.getShoppingCart();
//
//        Set<CartItem> cartItems = cart.getCartItem();
//
//        CartItem item = findCartItem(cartItems, product.getProductid());
//
//        item.setQuantity(quantity);
//        item.setTotalPrice(quantity * product.getPrice());
//
//        itemRepository.save(item);
//
//        int totalItems = totalItems(cartItems);
//        double totalPrice = totalPrice(cartItems);
//
//        cart.setTotalItems(totalItems);
//        cart.setTotalPrices(totalPrice);
//
//        return cartRepository.save(cart);
//    }
//
//    @Override
//    public ShoppingCart deleteItemFromCart(Product product, User customer) {
//        ShoppingCart cart = customer.getShoppingCart();
//
//        Set<CartItem> cartItems = cart.getCartItem();
//
//        CartItem item = findCartItem(cartItems, product.getProductid());
//
//        cartItems.remove(item);
//
//        itemRepository.delete(item);
//
//        double totalPrice = totalPrice(cartItems);
//        int totalItems = totalItems(cartItems);
//
//        cart.setCartItem(cartItems);
//        cart.setTotalItems(totalItems);
//        cart.setTotalPrices(totalPrice);
//
//        return cartRepository.save(cart);
//    }
//
//    public CartItem findCartItem(Set<CartItem> cartItems, Long productId) {
//        if (cartItems == null) {
//            return null;
//        }
//        CartItem cartItem = null;
//
//        for (CartItem item : cartItems) {
//            if (item.getProduct().getProductid() == productId) {
//                cartItem = item;
//            }
//        }
//        return cartItem;
//    }
//
//    private int totalItems(Set<CartItem> cartItems){
//        int totalItems = 0;
//        for(CartItem item : cartItems){
//            totalItems += item.getQuantity();
//        }
//        return totalItems;
//    }
//
//    private double totalPrice(Set<CartItem> cartItems){
//        double totalPrice = 0.0;
//
//        for(CartItem item : cartItems){
//            totalPrice += item.getTotalPrice();
//        }
//
//        return totalPrice;
//    }
}
