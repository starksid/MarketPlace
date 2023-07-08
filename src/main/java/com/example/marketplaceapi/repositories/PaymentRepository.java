package com.example.marketplaceapi.repositories;

import com.example.marketplaceapi.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Override
    Payment save(Payment entity);

    @Override
    Optional<Payment> findById(Integer integer);
}
