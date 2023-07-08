package com.example.marketplaceapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpSellerDtoRequest {
    private String name;
    private String email;
    private String password;
}
