package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
