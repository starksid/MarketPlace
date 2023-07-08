package com.example.marketplaceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseModel {
    @OneToMany
    private List<BuyerProductQuantity> buyerProductQuantities;
    @OneToOne
    private Buyer buyer;
    @OneToMany
    private List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private CartStatus cartStatus;
    private int paymentLeft;
    private int totalAmount;
}











