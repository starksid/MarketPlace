package com.example.marketplaceapi.dtos;

import com.example.marketplaceapi.models.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakePaymentResponseDto {
    private Payment payment;
}
