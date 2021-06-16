package com.poly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the CATEGORYS database table.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor


public class CategoryDTO implements Serializable {



	private Long categoryID;

	@NotEmpty
	@Min(value = 5)

	private String name;





}