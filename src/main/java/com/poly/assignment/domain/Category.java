package com.poly.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the CATEGORYS database table.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")

public class Category implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryID;


	@Column(name = "category_name", length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;




}