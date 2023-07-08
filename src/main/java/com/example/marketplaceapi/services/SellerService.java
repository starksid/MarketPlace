package com.example.marketplaceapi.services;

import com.example.marketplaceapi.models.Seller;
import com.example.marketplaceapi.models.UserType;
import com.example.marketplaceapi.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SellerService {
    private SellerRepository sellerRepository;
    @Autowired
    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }
    public Seller signUp(String name, String email, String password){
        Optional<Seller> optionalSeller = sellerRepository.findSellerByEmail(email);
        if(optionalSeller.isPresent()){
            return optionalSeller.get();
        }
        Seller seller1 = new Seller();
        seller1.setName(name);
        seller1.setProducts(new ArrayList<>());
        seller1.setEmail(email);
        seller1.setPassword(password);
        seller1.setUserType(UserType.SELLER);
        Seller seller2 = sellerRepository.save(seller1);
        return seller2;
    }
    public Seller signIn(String email, String password){
        Optional<Seller> seller1 = sellerRepository.findSellerByEmail(email);
        if(seller1==null){
            return null;
        }
        Seller seller = seller1.get();
        if(seller.getPassword()==password){
            return seller;
        }
        return null;
    }
    public Seller getSellerById(int id){
        Optional<Seller> optional = sellerRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Seller seller = optional.get();
        return seller;
    }
}
