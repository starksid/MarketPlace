package com.example.marketplaceapi.services;

import com.example.marketplaceapi.models.MarketPlace;
import com.example.marketplaceapi.models.Product;
import com.example.marketplaceapi.models.ProductStatus;
import com.example.marketplaceapi.models.Seller;
import com.example.marketplaceapi.repositories.MarketPlaceRepository;
import com.example.marketplaceapi.repositories.ProductRepository;
import com.example.marketplaceapi.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private SellerRepository sellerRepository;
    private MarketPlaceRepository marketPlaceRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, SellerRepository sellerRepository, MarketPlaceRepository marketPlaceRepository){
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.marketPlaceRepository = marketPlaceRepository;

    }

    public Product createProduct(String title, String description, int price, int quantity, int seller_id, int marketId){
        Optional<Seller> seller = sellerRepository.findById(seller_id);
        if(seller.isEmpty()){
            return null;
        }
        Optional<MarketPlace> marketPlace = marketPlaceRepository.findById(marketId);
        if(marketPlace.isEmpty()){
            return null;
        }
        MarketPlace marketPlace1 = marketPlace.get();
        Seller seller1 = seller.get();
        Product product = new Product();
        product.setSeller(seller1);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setProductStatus(ProductStatus.IN_STOCK);
        Product product1 = productRepository.save(product);
        seller1.getProducts().add(product1);
        sellerRepository.save(seller1);
        marketPlace1.getProducts().add(product1);
        marketPlaceRepository.save(marketPlace1);
        return product1;

    }




}
