package com.cts.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.dao.UserDao;
import com.cts.model.User;
@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		String sql="Insert into registration_user values(?,?,?,?,?,?)";
		int update = template.update(sql, user.getFirstName(),user.getLastName(),Long.parseLong(user.getContactNo()),user.getEmail(),user.getPassword(),java.sql.Date.valueOf(user.getDob()));
		return update;
	}

	@Override
	public boolean validate(User user) {
		String password="";
		String query = "select password from registration_user where email=?"; 
        Object[] inputs = new Object[] {user.getEmail()};
        try {
        password = template.queryForObject(query, inputs, String.class);
        }
        catch(Exception e) {
        	e.printStackTrace();
        	return false;
        }
        if(password.equals(""))
			return false;
		else {
		String sql="Select * from registration_user where email=?";
		User user1= template.queryForObject(sql, new Object[] { user.getEmail() }, new BeanPropertyRowMapper<User>(User.class));
		if(user1.getPassword().equals(user.getPassword()) && user1!=null)
			return true;
		else
			return false;
	}}
	
	@Override
	public boolean validateEmail(User user) {
		String sql="Select * from registration_user where email=?";
		try {
		User user1= template.queryForObject(sql, new Object[] { user.getEmail() }, new BeanPropertyRowMapper<User>(User.class));
		if(user1==null)
			return true;
		else
			return false;}
		catch(Exception e)
		{
			return true;
		}
	}
}
