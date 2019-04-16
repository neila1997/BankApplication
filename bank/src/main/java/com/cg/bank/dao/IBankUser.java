package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bank.model.User;

public interface IBankUser extends JpaRepository<User,String>{
 
	@Query("SELECT user FROM User user where user.userId=?1 AND user.userPassword=?2")
	public User findByIdAndPassword(String userId,String userPassword);
}
