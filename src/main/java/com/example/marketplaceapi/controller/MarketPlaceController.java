package com.example.marketplaceapi.controller;

import com.example.marketplaceapi.models.MarketPlace;
import com.example.marketplaceapi.models.Product;
import com.example.marketplaceapi.services.MarketPlaceService;
import com.example.marketplaceapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marketplace")
public class MarketPlaceController {
    ProductService productService;
    MarketPlaceService marketPlaceService;
    @Autowired
    public MarketPlaceController(ProductService productService, MarketPlaceService marketPlaceService){
        this.productService = productService;
        this.marketPlaceService = marketPlaceService;
    }
    @PostMapping("/createmarketplace")
    public ResponseEntity<MarketPlace> createMartketPlace(){
        MarketPlace marketPlace = marketPlaceService.createMarketPlace();
        if(marketPlace==null){
            return ResponseEntity.badRequest().body(marketPlace);
        }
        return ResponseEntity.ok(marketPlace);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable int marketId){
        List<Product> products = marketPlaceService.displayProducts(marketId);
        return ResponseEntity.ok(products);
    }



}
