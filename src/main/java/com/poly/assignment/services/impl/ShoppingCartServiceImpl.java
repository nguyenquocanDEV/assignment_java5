package com.poly.assignment.services.impl;

import com.poly.assignment.model.CartItemDTO;
import com.poly.assignment.services.ShoppingCartService;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Map<Long, CartItemDTO> map = new HashMap<Long, CartItemDTO>();

    // them 1 sp vao gio hang

    @Override
    public void add(CartItemDTO item) {
        // kiem tra sp co trong gio hang chua
        CartItemDTO exitCartItem = map.get(item.getProductId());
        if (exitCartItem != null) {
            exitCartItem.setQuantity(item.getQuantity() + exitCartItem.getQuantity());
        } else {
            map.put(item.getProductId(), item);
        }

    }

    // xoa sp trong gio hang

    @Override
    public void remove(Long productId) {
        map.remove(productId);
    }

    // lay danh sach sp

    @Override
    public Collection<CartItemDTO> getProduct() {
        return map.values();
    }

    // xoa tat ca sp trong gio hang

    @Override
    public void clear() {
        map.clear();
    }

    // update sp trong gio hang

    @Override
    public void update(Long productId, int quantity) {
        CartItemDTO item = map.get(productId);
        item.setQuantity(quantity);
        if (quantity <= 0) {
            map.remove(productId);
        }
    }

    // tính tổng giá trên hóa đơn

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getUnitPrice()).sum();
    }
    //lay sl tat ca sp

    @Override
    public int getCount() {
        if (map.isEmpty()) {
            return 0;
        } else {
            return map.values().size();
        }
    }

}
