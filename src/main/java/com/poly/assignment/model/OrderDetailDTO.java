package com.poly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetailDTO implements Serializable {



	private int orderDetailId;

	private int orderId;

	private int productId;


	private int quantity;


	private double unitPrice;


}


