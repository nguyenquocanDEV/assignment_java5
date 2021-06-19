package com.poly.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the ACCOUNTS database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accounts")

public class Account implements Serializable {


	@Id
	@Column(length = 30)
	private String username;


	@Column(length = 20, nullable = false)
	private String password;

}