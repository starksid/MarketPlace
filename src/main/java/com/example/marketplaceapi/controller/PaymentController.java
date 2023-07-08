package com.example.marketplaceapi.controller;

import com.example.marketplaceapi.dtos.MakePaymentRequestDto;
import com.example.marketplaceapi.dtos.MakePaymentResponseDto;
import com.example.marketplaceapi.models.Payment;
import com.example.marketplaceapi.models.PaymentStatus;
import com.example.marketplaceapi.services.PaymentService;
import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping("/makePayments")
    public ResponseEntity<MakePaymentResponseDto> makePayment(@RequestBody MakePaymentRequestDto request){
        Payment payment = paymentService.makePayment(request.getAmount(), request.getCartId());
        MakePaymentResponseDto response = new MakePaymentResponseDto();
        if(payment==null){
            return ResponseEntity.badRequest().body(response);
        }
        response.setPayment(payment);
        return ResponseEntity.ok(response);



    }
}
