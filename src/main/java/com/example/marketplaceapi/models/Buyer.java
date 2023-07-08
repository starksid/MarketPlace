package com.example.marketplaceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buyer extends BaseModel{
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    @OneToOne
    private Cart cart;

}
