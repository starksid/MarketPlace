package com.example.marketplaceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductsToCartDtoRequest {
    private int productId;
    private int buyerId;
    private int quantity;
}
