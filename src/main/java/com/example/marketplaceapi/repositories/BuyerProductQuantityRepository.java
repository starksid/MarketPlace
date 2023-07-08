package com.example.marketplaceapi.repositories;

import com.example.marketplaceapi.models.BuyerProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerProductQuantityRepository extends JpaRepository<BuyerProductQuantity, Integer> {
    @Override
    BuyerProductQuantity save(BuyerProductQuantity entity);

    @Override
    Optional<BuyerProductQuantity> findById(Integer integer);
}
