package com.cg.bank.service;

import java.util.List;

import com.cg.bank.model.Account;
import com.cg.bank.model.Transaction;
import com.cg.bank.model.User;


public interface IService {
	public User checkLogin(String userId,String userPassword);
	public boolean saveUser(User user);
	public void saveTransaction(Transaction transaction);
	public boolean saveAccount(Account account);
	public void depositToAccount(long accountNumber,long transferAmount);
	public boolean withdrawFromAccount(long accountNumber,long transferAmount);
	public boolean transferAmount(long accountFrom,long accountTo,long transferAmount);
	public User findById(String userId);
	public Account findByAccountNumber(long accountNumber);
	public void update(User user);
	public User showBal(User user);
	public List<Transaction> showTransactions(long accountNumber);
}
