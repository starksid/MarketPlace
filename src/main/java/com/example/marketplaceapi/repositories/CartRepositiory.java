package com.example.marketplaceapi.repositories;

import com.example.marketplaceapi.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepositiory extends JpaRepository<Cart, Integer> {
    @Override
    Cart save(Cart entity);

    @Override
    Optional<Cart> findById(Integer integer);
}
