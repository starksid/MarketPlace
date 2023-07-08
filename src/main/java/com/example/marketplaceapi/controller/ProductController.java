package com.example.marketplaceapi.controller;

import com.example.marketplaceapi.dtos.CreateProductDtoRequest;
import com.example.marketplaceapi.dtos.CreateProductDtoResponse;
import com.example.marketplaceapi.models.Product;
import com.example.marketplaceapi.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/addproduct")
    public ResponseEntity<CreateProductDtoResponse> addNewProduct(@RequestBody CreateProductDtoRequest request){
        Product product = productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getPrice(),
                request.getQuantity(),
                request.getSeller_id(),
                request.getMarketPlaceId()
        );
        CreateProductDtoResponse response = new CreateProductDtoResponse();
        if(product==null){
            return ResponseEntity.badRequest().body(response);
        }
        response.setProductId(product.getId());

        return ResponseEntity.ok(response);

    }


}

