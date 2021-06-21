package com.poly.assignment.dao;

import com.poly.assignment.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountsDAO extends JpaRepository<Account, String> {



}
