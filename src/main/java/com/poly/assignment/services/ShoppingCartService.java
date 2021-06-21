package com.poly.assignment.services;

import com.poly.assignment.model.CartItemDTO;


import java.util.Collection;

public interface ShoppingCartService {


    void add(CartItemDTO item);

    void remove(Long productId);

    Collection<CartItemDTO> getProduct();

    void clear();

    void update(Long productId, int quantity);

    double getAmount();

    int getCount();
}
