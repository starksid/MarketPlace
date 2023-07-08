package com.example.marketplaceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpBuyerDtoRequest {

    private String name;
    private String email;
    private String password;
}
