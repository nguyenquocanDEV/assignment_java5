package com.poly.assignment.dao;

import com.poly.assignment.domain.Customer;
import com.poly.assignment.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersDAO extends JpaRepository<Order, Integer> {
    @Query("select u from Order u where u.customer = ?1")
    List<Order> findByCutomer(Customer customer);
}
