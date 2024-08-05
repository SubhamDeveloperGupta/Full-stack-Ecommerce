package com.cart.service.cart_service.controller;

import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.service.CartDetailsService;
import com.cart.service.cart_service.util.CartRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartDetailsController {

    private final CartDetailsService cartDetailsService;

    public CartDetailsController(CartDetailsService cartDetailsService) {
        this.cartDetailsService = cartDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<CartDetails>> getAllCart() {
        return new ResponseEntity<>(cartDetailsService.getAllCart(), HttpStatus.OK);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<CartDetails> getAllCartsProductByUserId(@RequestParam Integer userId) {
        return new ResponseEntity<>(cartDetailsService.getAllCartsProductByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CartDetails> createCart(@RequestBody CartRequest request) {
        return new ResponseEntity<>(cartDetailsService.createCart(request), HttpStatus.CREATED);
    }

    @PutMapping("/product/add")
    public ResponseEntity<CartDetails> addProductUpdateCart(@RequestBody CartRequest request) {
        return new ResponseEntity<>(cartDetailsService.addNewItemToCart(request.getUserId(), request.getProduct()), HttpStatus.OK);
    }

    @PutMapping("/product/delete")
    public ResponseEntity<CartDetails> deleteProduct(@RequestBody CartRequest request) {
        return new ResponseEntity<>(cartDetailsService.decreaseProduct(request.getUserId(), request.getProduct()), HttpStatus.OK);
    }


}
