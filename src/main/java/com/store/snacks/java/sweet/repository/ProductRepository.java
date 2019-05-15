package com.store.snacks.java.sweet.repository;

import com.store.snacks.java.sweet.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author ngan nnh on 5/13/2019
 * @project sweet
 */

public interface ProductRepository extends JpaRepository<Product,String> {
    @Override List<Product> findAll();
    @Override Optional<Product> findById(String id);
    @Override void delete(Product product);
}
