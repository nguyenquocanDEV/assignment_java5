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


public class CustomerDTO implements Serializable {

	private int customerId;


	private String email;


	private String name;


	private String password;


	private String phone;


	private Date registeredDate;


	private int status;
	private Boolean isEdit = false;


}