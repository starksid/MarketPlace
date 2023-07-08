package com.example.marketplaceapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BuyerProductQuantity extends BaseModel{
    private int quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Buyer buyer;


}
