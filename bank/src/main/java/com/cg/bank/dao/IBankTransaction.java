package com.cg.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bank.model.Transaction;

public interface IBankTransaction extends JpaRepository<Transaction,Long>{

	@Query("SELECT transaction FROM Transaction transaction where transaction.accountFrom=?1 OR transaction.accountTo=?1")
	public List<Transaction> findByAccountNumber(long accountNumber);
}
