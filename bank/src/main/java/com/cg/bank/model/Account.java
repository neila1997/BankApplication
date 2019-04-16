package com.cg.bank.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account")
	@SequenceGenerator(name = "account", sequenceName = "account", initialValue = 10001, allocationSize = 1)
	private long accountNumber;
	private String accountType, transactionPassword;
	long accountBalance;

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	@ManyToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
	Set<User> users = new HashSet<User>();

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	Set<Transaction> transactions = new HashSet<Transaction>();

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void addTransaction(Transaction transaction) {
		transaction.setAccount(this);
		this.getTransactions().add(transaction);
	}

	public void addUser(User user) {
		user.addAccount(this);
		this.getUsers().add(user);

	}

}
