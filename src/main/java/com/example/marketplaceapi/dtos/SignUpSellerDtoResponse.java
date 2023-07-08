package com.example.marketplaceapi.dtos;

import com.example.marketplaceapi.models.Seller;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpSellerDtoResponse {
    private Seller seller;
}
