package com.poly.assignment.dao;

import com.poly.assignment.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDAO  extends JpaRepository<Customer, Integer> {
    List<Customer> findByNameContaining(String name);
    List<Customer> findByEmailContaining(String email);
}
