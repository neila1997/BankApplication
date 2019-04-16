package com.cg.bank.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bank.model.Account;
import com.cg.bank.model.Transaction;
import com.cg.bank.model.User;
import com.cg.bank.service.IService;

@RestController
@RequestMapping("/user")
public class BankController {
	@Autowired
	IService service;
	User user;
	Account account;

	@PostMapping(path = "/createuser")
	public ModelAndView createUser(@RequestParam String userName, @RequestParam String userId,
			@RequestParam String userPassword, @RequestParam String userEmail, @RequestParam String userAddress,
			@RequestParam Date userDob, @RequestParam String userPhone, @RequestParam String accountType,
			@RequestParam String transactionPassword) {
		account = new Account();
		account.setAccountType(accountType);
		account.setTransactionPassword(transactionPassword);
		account.setAccountBalance(0);
		user = service.findById(userId);
		System.out.println(user);
		if (user != null) {
			user.addAccount(account);
			service.update(user);
		} else {
			user = new User();
			user.setUserName(userName);
			user.setUserId(userId);
			user.setUserPassword(userPassword);
			user.setUserEmail(userEmail);
			user.setUserDob(userDob);
			user.setUserPhone(userPhone);
			user.setUserAddress(userAddress);
			user.addAccount(account);
			service.update(user);
		}
		ModelAndView model = new ModelAndView("GetUser");
		model.addObject("USER", user);
		return model;
	}

	@PostMapping(path = "/checkuser")
	public ModelAndView checkLogin(@RequestParam String userId, @RequestParam String userPassword) {
		user = service.checkLogin(userId, userPassword);
		ModelAndView model = new ModelAndView("Error");
		if (user != null)
			model = new ModelAndView("Menu");
		model.addObject("USER", user);
		return model;
	}

	@GetMapping(path = "/deposit/{user}")
	public ModelAndView depositToAccount(@PathVariable User user) {
		ModelAndView model = new ModelAndView("Deposit");
		model.addObject("USER", user);
		return model;
	}

	@PostMapping(path = "/depositmoney")
	public ModelAndView depositToAccount(@RequestParam long accountNumber, @RequestParam long transferAmount) {
		service.depositToAccount(accountNumber, transferAmount);
		ModelAndView model = new ModelAndView("Menu");
		model.addObject("USER", user);
		return model;
	}

	@GetMapping(path = "/withdraw/{user}")
	public ModelAndView withdrawFromAccount(@PathVariable User user) {
		ModelAndView model = new ModelAndView("Withdraw");
		model.addObject("USER", user);
		return model;
	}

	@PostMapping(path = "/withdraw")
	public ModelAndView withdrawFromAccount(@RequestParam long accountNumber, @RequestParam long transferAmount) {
		service.withdrawFromAccount(accountNumber, transferAmount);
		ModelAndView model = new ModelAndView("Menu");
		model.addObject("USER", user);
		return model;
	}

	@GetMapping(path = "/transfer/{user}")
	public ModelAndView transferToAccount(@PathVariable User user) {
		ModelAndView model = new ModelAndView("Transfer");
		model.addObject("USER", user);
		return model;
	}

	@PostMapping(path = "/transfermoney")
	public ModelAndView transferToAccount(@RequestParam long accountFrom, @RequestParam long accountTo,
			@RequestParam long transferAmount) {
		service.transferAmount(accountFrom, accountTo, transferAmount);
		ModelAndView model = new ModelAndView("Menu");
		model.addObject("USER", user);
		return model;
	}

	@GetMapping(path = "/balance/{user}")
	public ModelAndView showBal(@PathVariable User user) {
		user = service.showBal(user);
		ModelAndView model = new ModelAndView("Balance");
		model.addObject("USER", user);
		return model;
	}

	@PostMapping(path = "/transactions")
	public ModelAndView showTransactions(@RequestParam long accountNumber) {
		List<Transaction> transaction = service.showTransactions(accountNumber);
		ModelAndView model = new ModelAndView("Transactions");
		model.addObject("TRANSACTIONS", transaction);
		return model;
	}

}
