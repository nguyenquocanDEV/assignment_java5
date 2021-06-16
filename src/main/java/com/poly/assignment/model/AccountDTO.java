package com.poly.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the ACCOUNTS database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor


public class AccountDTO implements Serializable {



	private String username;


	private String password;

}