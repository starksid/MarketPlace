package com.example.marketplaceapi.repositories;

import com.example.marketplaceapi.models.Buyer;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Optional<Buyer> findBuyerByEmail(String email);

    @Override
    Optional<Buyer> findById(Integer integer);

    @Override
    Buyer save(Buyer entity);
}
