package com.cg.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.dao.IBankAccount;
import com.cg.bank.dao.IBankTransaction;
import com.cg.bank.dao.IBankUser;
import com.cg.bank.model.Account;
import com.cg.bank.model.Transaction;
import com.cg.bank.model.User;

@Service
public class IServiceImpl implements IService {
	@Autowired
	IBankAccount accountdao;
	@Autowired
	IBankUser userdao;
	@Autowired
	IBankTransaction transactiondao;

	@Override
	public boolean saveUser(User user) {
		boolean bool = false;
		if (!userdao.existsById(user.getUserId())) {
			bool = true;
			userdao.save(user);
		}
		return bool;
	}

	@Override
	public void update(User user) {
		userdao.save(user);
	}

	@Override
	public User findById(String userId) {
		User user = null;
		if (userdao.existsById(userId)) {
			user = userdao.getOne(userId);
		}
		return user;
	}

	@Override
	public Account findByAccountNumber(long accountNumber) {
		return accountdao.getOne(accountNumber);
	}

	@Override
	public User checkLogin(String userId, String userPassword) {
		return userdao.findByIdAndPassword(userId, userPassword);
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		transactiondao.save(transaction);
	}

	@Override
	public boolean saveAccount(Account account) {
		boolean bool = false;
		if (!accountdao.existsById(account.getAccountNumber())) {
			bool = true;
			accountdao.save(account);
		}
		return bool;
	}

	@Override
	public void depositToAccount(long accountNumber, long transferAmount) {
		Account account = accountdao.getOne(accountNumber);
		account.setAccountBalance(account.getAccountBalance() + transferAmount);
		Transaction transaction = new Transaction();
		transaction.setTransferAmount(transferAmount);
		transaction.setAccountFrom(accountNumber);
		transaction.setAccount(account);
		this.saveTransaction(transaction);
	}

	@Override
	public boolean withdrawFromAccount(long accountNumber, long transferAmount) {
		Account account = accountdao.getOne(accountNumber);
		boolean bool = false;
		if (account.getAccountBalance() >= transferAmount) {
			account.setAccountBalance(account.getAccountBalance() - transferAmount);
			bool = true;
			Transaction transaction = new Transaction();
			transaction.setAccountFrom(accountNumber);
			transaction.setTransferAmount(transferAmount);
			transaction.setAccount(account);
			this.saveTransaction(transaction);
		}
		return bool;
	}

	@Override
	public boolean transferAmount(long accountFrom, long accountTo, long transferAmount) {
		boolean bool = false;
		Account account = accountdao.getOne(accountFrom);
		Account account1 = accountdao.getOne(accountTo);
		if (account.getAccountBalance() >= transferAmount) {
			account.setAccountBalance(account.getAccountBalance() - transferAmount);
			account1.setAccountBalance(account1.getAccountBalance() + transferAmount);
			Transaction transaction = new Transaction();
			transaction.setAccountFrom(accountFrom);
			transaction.setAccountTo(accountTo);
			transaction.setTransferAmount(transferAmount);
			transaction.setAccount(account1);
			this.saveAccount(account);
			this.saveAccount(account1);
			this.saveTransaction(transaction);
			bool = true;
		}
		return bool;
	}

	@Override
	public User showBal(User user) {
		return userdao.getOne(user.getUserId());
	}

	public List<Transaction> showTransactions(long accountNumber) {
		return transactiondao.findByAccountNumber(accountNumber);
	}
}
