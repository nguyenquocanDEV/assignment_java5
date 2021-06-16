package com.poly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class ProductDTO implements Serializable {


	private int productId;


	private String name;

	private int quantity;

	private double unitPrice;


	private String image;


	private String description;


	private double discount;


	private Date enteredDate;


	private short status;



}
