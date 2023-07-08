package com.example.marketplaceapi.repositories;

import com.example.marketplaceapi.models.MarketPlace;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketPlaceRepository extends JpaRepository<MarketPlace, Integer> {
    @Override
    MarketPlace save(MarketPlace entity);

    @Override
    Optional<MarketPlace> findById(Integer integer);
}
