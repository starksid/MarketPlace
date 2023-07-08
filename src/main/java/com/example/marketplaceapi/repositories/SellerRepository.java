package com.example.marketplaceapi.repositories;

import com.example.marketplaceapi.models.Seller;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
    Optional<Seller> findSellerByEmail(String email);

    @Override
    Optional<Seller> findById(Integer integer);

    @Override
    Seller save(Seller entity);
}
