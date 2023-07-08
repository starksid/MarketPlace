package com.example.marketplaceapi.services;

import com.example.marketplaceapi.models.MarketPlace;
import com.example.marketplaceapi.models.Product;
import com.example.marketplaceapi.repositories.MarketPlaceRepository;
import com.example.marketplaceapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarketPlaceService {
    MarketPlaceRepository marketPlaceRepository;
    ProductRepository productRepository;
    @Autowired
    public MarketPlaceService(MarketPlaceRepository marketPlaceRepository, ProductRepository productRepository){
        this.marketPlaceRepository = marketPlaceRepository;
        this.productRepository = productRepository;
    }
    public MarketPlace createMarketPlace(){
        MarketPlace marketPlace = new MarketPlace();
        marketPlace.setProducts(new ArrayList<>());
        MarketPlace marketPlace1 = marketPlaceRepository.save(marketPlace);
        return marketPlace1;
    }

    public List<Product> displayProducts(int marketId){
        Optional<MarketPlace> marketPlace = marketPlaceRepository.findById(marketId);
        if(marketPlace.isEmpty()){
            return null;
        }
        MarketPlace marketPlace1 = marketPlace.get();
        return marketPlace1.getProducts();
    }
}
