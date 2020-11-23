package com.cts.dao;

import com.cts.model.Manager;

public interface ManagerDao {

	public int save(Manager manager);

	public boolean validate(Manager manager);
	
	public boolean validateEmail(Manager manager);

}
