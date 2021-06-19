package com.poly.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int customerId;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String email;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String name;

	@Column(length = 20 ,nullable = false)
	private String password;

	@Column(length = 20)
	private String phone;

	@Temporal(TemporalType.DATE)
	private Date registeredDate;

	@Column(nullable = false)
	private int status;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;

}