package com.cg.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction")
	@SequenceGenerator(name = "transaction", sequenceName = "transaction", initialValue = 1, allocationSize = 1)
	private long transactionNo;
	private long accountFrom, accountTo, transferAmount;

	public long getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(long accountFrom) {
		this.accountFrom = accountFrom;
	}

	public long getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(long accountTo) {
		this.accountTo = accountTo;
	}

	public long getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(long transferAmount) {
		this.transferAmount = transferAmount;
	}

	@ManyToOne()
	@JoinColumn()
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
