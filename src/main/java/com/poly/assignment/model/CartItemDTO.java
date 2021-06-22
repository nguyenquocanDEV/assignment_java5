package com.poly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
	private Long productID;
	private String name;
	private int quantity;
	private double unitPrice;
	private double discount;
}
