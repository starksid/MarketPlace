package com.example.marketplaceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakePaymentRequestDto {
    private int amount;
    private String paymentType;
    private int cartId;
}
