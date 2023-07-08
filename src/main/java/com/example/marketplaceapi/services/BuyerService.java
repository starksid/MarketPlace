package com.example.marketplaceapi.services;

import com.example.marketplaceapi.models.Buyer;
import com.example.marketplaceapi.models.Cart;
import com.example.marketplaceapi.models.UserType;
import com.example.marketplaceapi.repositories.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BuyerService {
    private BuyerRepository buyerRepository;
    @Autowired
    public BuyerService(BuyerRepository buyerRepository){
        this.buyerRepository = buyerRepository;
    }
    public Buyer signUp(String name, String email, String password){
        Optional<Buyer> optionalBuyer = buyerRepository.findBuyerByEmail(email);
        if(optionalBuyer.isPresent()){
            return optionalBuyer.get();
        }

        Buyer buyer1 = new Buyer();

        buyer1.setName(name);
        buyer1.setEmail(email);
        buyer1.setPassword(password);
        buyer1.setUserType(UserType.BUYER);
        Buyer buyer2 = buyerRepository.save(buyer1);
        return buyer2;
    }
    public Buyer signIn(String email, String password){
        Optional<Buyer> buyer = buyerRepository.findBuyerByEmail(email);
        if(buyer.isEmpty()){
            return null;
        }
        Buyer buyer1 = buyer.get();
        if(buyer1.getPassword()==password){
            return buyer1;
        }
        return null;
    }

    public Buyer getBuyerById(int id){
        Optional<Buyer> buyer = buyerRepository.findById(id);
        if(buyer.isEmpty()){
            return null;
        }
        Buyer buyer1 = buyer.get();
        return buyer1;
    }
}
