package com.day8.Spring_Cloudinary.repository;

import com.day8.Spring_Cloudinary.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
