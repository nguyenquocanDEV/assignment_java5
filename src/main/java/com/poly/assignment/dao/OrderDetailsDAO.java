package com.poly.assignment.dao;

import com.poly.assignment.domain.Order;
import com.poly.assignment.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailsDAO extends JpaRepository<OrderDetail, Integer> {
    @Query("select u from OrderDetail u where u.order = ?1")
    List<OrderDetail> findByOrder(Order order);

}
