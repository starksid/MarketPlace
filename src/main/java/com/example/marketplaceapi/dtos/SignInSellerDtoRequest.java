package com.example.marketplaceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInSellerDtoRequest {
    private String email;
    private String password;
}
