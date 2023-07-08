package com.example.marketplaceapi.dtos;

import com.example.marketplaceapi.models.Buyer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpBuyerDtoResponse {
    private Buyer buyer;
}
