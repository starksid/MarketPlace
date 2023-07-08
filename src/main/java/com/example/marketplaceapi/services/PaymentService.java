package com.example.marketplaceapi.services;

import com.example.marketplaceapi.models.*;
import com.example.marketplaceapi.repositories.CartRepositiory;
import com.example.marketplaceapi.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private CartRepositiory cartRepositiory;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository, CartRepositiory cartRepositiory){
        this.cartRepositiory = cartRepositiory;
        this.paymentRepository = paymentRepository;
    }
    public Payment makePayment(int amount, int cartId){
        Optional<Cart> cartOptional = cartRepositiory.findById(cartId);
        if(cartOptional.isEmpty()){
            return null;
        }
        Cart cart = cartOptional.get();
        Payment payment;
        if(cart.getPaymentLeft()>=amount){
            payment = new Payment();
            payment.setPaymentMode(PaymentMode.UPI);
            payment.setAmount(amount);
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
            Payment payment1 = paymentRepository.save(payment);
            payment = payment1;
            cart.setPaymentLeft(cart.getPaymentLeft()-amount);
            cart.getPayments().add(payment);
            if(cart.getPaymentLeft()==0){
                cart.setCartStatus(CartStatus.COMPLETED);
            }
            cartRepositiory.save(cart);
            return payment1;
        }
        payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        payment.setPaymentMode(PaymentMode.UPI);
        payment.setAmount(cart.getPaymentLeft());
        cart.setPaymentLeft(0);
        cart.setCartStatus(CartStatus.COMPLETED);
        Payment payment1 = paymentRepository.save(payment);
        cartRepositiory.save(cart);


        return payment1;


    }
}
