package com.cts.dao;

import com.cts.model.User;

public interface UserDao {
	public int save(User user);
	
	public boolean validate(User user);
	
	public boolean validateEmail(User user);
}