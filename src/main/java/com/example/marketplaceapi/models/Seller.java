package com.example.marketplaceapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends BaseModel{
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    @OneToMany
    private List<Product> products;
}
