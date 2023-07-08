package com.example.marketplaceapi.controller;

import com.example.marketplaceapi.dtos.AddProductsToCartDtoRequest;
import com.example.marketplaceapi.dtos.AddProductsToCartDtoResponse;
import com.example.marketplaceapi.models.Cart;
import com.example.marketplaceapi.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }
    @PostMapping("/addProducts")
    public ResponseEntity<AddProductsToCartDtoResponse> addProducts(@RequestBody AddProductsToCartDtoRequest request){
        Cart cart = cartService.addProduct(
                request.getProductId(),
                request.getQuantity(),
                request.getBuyerId()
        );
        AddProductsToCartDtoResponse response = new AddProductsToCartDtoResponse();

        if(cart==null){
            ResponseEntity.badRequest().body(response);
        }
        response.setCartId(cart.getId());
        return ResponseEntity.ok(response);
    }
}
