package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bank.model.Account;

public interface IBankAccount extends JpaRepository<Account,Long>{

}
