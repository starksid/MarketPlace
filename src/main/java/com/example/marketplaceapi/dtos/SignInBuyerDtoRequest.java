package com.example.marketplaceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInBuyerDtoRequest {
    private String email;
    private String password;
}
