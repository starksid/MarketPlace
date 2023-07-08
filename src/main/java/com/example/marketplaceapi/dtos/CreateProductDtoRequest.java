package com.example.marketplaceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDtoRequest {
    private String title;
    private String description;
    private int price;
    private int quantity;
    private int seller_id;
    private int marketPlaceId;
}
