package com.poly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * The persistent class for the ACCOUNTS database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor


public class AdminLoginDTO implements Serializable {
	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	private Boolean rememberMe = false;

}