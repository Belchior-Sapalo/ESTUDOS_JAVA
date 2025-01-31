package com.belchiorsapalo.crud.repository.product;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belchiorsapalo.crud.domain.product.Product;

public interface ProductRepo extends JpaRepository<Product, UUID>{
    public boolean existsByCategory(String category);
    public List<Product> findAllByCategory(String category);
}
