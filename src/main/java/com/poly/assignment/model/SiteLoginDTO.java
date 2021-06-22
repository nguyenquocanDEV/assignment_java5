package com.poly.assignment.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteLoginDTO {
	
	@Email
	private String email;
	@NotEmpty
	private String password;

}
