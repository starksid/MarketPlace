package com.example.marketplaceapi.services;

import com.example.marketplaceapi.controller.CartController;
import com.example.marketplaceapi.models.*;
import com.example.marketplaceapi.repositories.BuyerProductQuantityRepository;
import com.example.marketplaceapi.repositories.BuyerRepository;
import com.example.marketplaceapi.repositories.CartRepositiory;
import com.example.marketplaceapi.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepositiory cartRepositiory;
    private ProductRepository productRepository;
    private BuyerRepository buyerRepository;
    private BuyerProductQuantityRepository productQuantityRepository;
    public CartService(
            CartRepositiory cartRepositiory,
            ProductRepository productRepository,
            BuyerRepository buyerRepository,
            BuyerProductQuantityRepository productQuantityRepository
    ){
        this.cartRepositiory = cartRepositiory;
        this.buyerRepository = buyerRepository;
        this.productRepository = productRepository;
        this.productQuantityRepository = productQuantityRepository;
    }

    public Cart addProduct(int productId, int quantity, int buyerId){
        Optional<Buyer> optionalBuyer = buyerRepository.findById(buyerId);
        if(optionalBuyer.isEmpty()){
            return null;
        }
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            return null;
        }

        Buyer buyer = optionalBuyer.get();
        Product product = optionalProduct.get();
        if(product.getQuantity()<quantity){
            return null;
        }

        if(buyer.getCart()==null){
            Cart cart = new Cart();
            cart.setCartStatus(CartStatus.PENDING);
            cart.setBuyer(buyer);
            cart.setPayments(new ArrayList<>());
            cart.setBuyerProductQuantities(new ArrayList<>());
            cart.setTotalAmount(0);
            cart.setPaymentLeft(0);

            Cart cart1 = cartRepositiory.save(cart);
            buyer.setCart(cart1);
        } else if (buyer.getCart().getCartStatus().equals(CartStatus.COMPLETED )) {
            Cart cart = new Cart();

            cart.setCartStatus(CartStatus.PENDING);
            cart.setBuyer(buyer);
            cart.setPayments(new ArrayList<>());
            cart.setBuyerProductQuantities(new ArrayList<>());
            cart.setTotalAmount(0);
            cart.setPaymentLeft(0);

            Cart cart1 = cartRepositiory.save(cart);
            buyer.setCart(cart1);

        } else if(buyer.getCart().getCartStatus().equals(CartStatus.FAILED)){
            Cart cart = new Cart();
            cart.setCartStatus(CartStatus.PENDING);
            cart.setBuyer(buyer);
            cart.setPayments(new ArrayList<>());
            cart.setBuyerProductQuantities(new ArrayList<>());
            cart.setTotalAmount(0);
            cart.setPaymentLeft(0);

            Cart cart1 = cartRepositiory.save(cart);
            buyer.setCart(cart1);
        }


        Cart cart = buyer.getCart();

        BuyerProductQuantity productQuantity = productQuantityRepository.save(new BuyerProductQuantity(quantity, product, buyer));
        cart.getBuyerProductQuantities().add(productQuantity);



        int paymentLeft = cart.getPaymentLeft()+(quantity*product.getPrice());
        cart.setPaymentLeft(paymentLeft);

        int totalPayment = cart.getTotalAmount()+(quantity*product.getPrice());
        cart.setTotalAmount(totalPayment);

        Cart cart1 = cartRepositiory.save(cart);
        buyer.setCart(cart1);
        buyerRepository.save(buyer);

        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);

        return cart1;




    }
}









