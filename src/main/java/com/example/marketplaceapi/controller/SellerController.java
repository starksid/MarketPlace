package com.example.marketplaceapi.controller;

import com.example.marketplaceapi.dtos.*;
import com.example.marketplaceapi.models.MarketPlace;
import com.example.marketplaceapi.models.Product;
import com.example.marketplaceapi.models.Seller;
import com.example.marketplaceapi.services.MarketPlaceService;
import com.example.marketplaceapi.services.ProductService;
import com.example.marketplaceapi.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {
    ProductService productService;
    SellerService sellerService;
    MarketPlaceService marketPlaceService;
    @Autowired
    public SellerController(ProductService productService, SellerService sellerService, MarketPlaceService marketPlaceService){
        this.sellerService = sellerService;
        this.productService = productService;
        this.marketPlaceService = marketPlaceService;
    }
    @PostMapping("/signup")
    public ResponseEntity<SignUpSellerDtoResponse> signUp(@RequestBody SignUpSellerDtoRequest request){
        Seller seller = sellerService.signUp(request.getName(), request.getEmail(), request.getPassword());
        SignUpSellerDtoResponse response = new SignUpSellerDtoResponse();
        response.setSeller(seller);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/signin")
    public ResponseEntity<SignInSellerDtoResponse> signIn(@RequestBody SignInSellerDtoRequest request){
        Seller seller = sellerService.signIn(request.getEmail(), request.getPassword());

        SignInSellerDtoResponse response = new SignInSellerDtoResponse();
        if(seller==null){
            ResponseEntity.badRequest().body(response);
        }
        response.setSellerId(seller.getId());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable int id){
        Seller seller = sellerService.getSellerById(id);
        if(seller==null){
            return ResponseEntity.badRequest().body(seller);
        }
        return ResponseEntity.ok(seller);
    }




}
