package com.poly.assignment.dao;


import com.poly.assignment.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsDAO  extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
}
