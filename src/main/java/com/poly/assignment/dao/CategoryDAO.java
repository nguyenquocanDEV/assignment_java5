package com.poly.assignment.dao;


import com.poly.assignment.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
