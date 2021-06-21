package com.poly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
	private Long productId;
	private String name;
	private int quantity;
	private double unitPrice;
}
