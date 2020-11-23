package com.cts.service;

import org.springframework.stereotype.Component;

@Component
public class AdminValidate {
	
	public boolean validate(String userId,String password)
	{
		return userId.equals("admin")&&password.equalsIgnoreCase("admin");
	}

}
