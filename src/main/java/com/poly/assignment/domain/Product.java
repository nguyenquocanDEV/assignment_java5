package com.poly.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")

public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productID;

	@ManyToOne
	@JoinColumn(name ="categoryID")
	private Category category;

	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private double unitPrice;

	@Column(length = 200)
	private String image;

	@Column(columnDefinition = "nvarchar(500) not null")
	private String description;

	@Column(nullable = false)
	private double discount;

	@Temporal(TemporalType.DATE)
	private Date enteredDate;

	@Column(nullable = false)
	private short status;



	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
}
