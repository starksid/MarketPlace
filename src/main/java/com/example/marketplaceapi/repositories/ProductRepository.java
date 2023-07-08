package com.example.marketplaceapi.repositories;

import com.example.marketplaceapi.models.Product;
import com.example.marketplaceapi.services.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Override
    Product save(Product entity);

    @Override
    Optional<Product> findById(Integer integer);
}
