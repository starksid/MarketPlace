package com.example.marketplaceapi.controller;

import com.example.marketplaceapi.dtos.SignInBuyerDtoRequest;
import com.example.marketplaceapi.dtos.SignInBuyerDtoResponse;
import com.example.marketplaceapi.dtos.SignUpBuyerDtoRequest;
import com.example.marketplaceapi.dtos.SignUpBuyerDtoResponse;
import com.example.marketplaceapi.models.Buyer;
import com.example.marketplaceapi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    private BuyerService buyerService;
    private ProductService productService;
    private CartService cartService;
    private PaymentService paymentService;
    private MarketPlaceService marketPlaceService;
    @Autowired
    public BuyerController(
            BuyerService buyerService,
            ProductService productService,
            CartService cartService,
            PaymentService paymentService,
            MarketPlaceService marketPlaceService
    ){
        this.buyerService = buyerService;
        this.cartService = cartService;
        this.paymentService = paymentService;
        this.productService = productService;
        this.marketPlaceService = marketPlaceService;

    }
    @PostMapping("/signup")
    public ResponseEntity<SignUpBuyerDtoResponse> signUp(@RequestBody SignUpBuyerDtoRequest request){
        SignUpBuyerDtoResponse response = new SignUpBuyerDtoResponse();
        Buyer buyer = buyerService.signUp(request.getName(), request.getEmail(), request.getPassword());

        response.setBuyer(buyer);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/signin")
    public ResponseEntity<SignInBuyerDtoResponse> signIn(@RequestBody SignInBuyerDtoRequest request){
        Buyer buyer = buyerService.signIn(request.getEmail(), request.getPassword());
        SignInBuyerDtoResponse response = new SignInBuyerDtoResponse();
        if(buyer==null){
            return ResponseEntity.badRequest().body(response);
        }
        response.setBuyerId(buyer.getId());
        return ResponseEntity.ok(response);
    }
}
