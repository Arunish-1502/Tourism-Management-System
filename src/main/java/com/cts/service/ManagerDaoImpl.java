package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cts.dao.ManagerDao;
import com.cts.model.Manager;
import com.cts.model.User;

@Service
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	JdbcTemplate template;

	@Override
	public int save(Manager manager) {
		String[] skills = manager.getSkills();
		String str = "";
		for (int i = 0; i < skills.length; i++) {
			if (i == 0)
				str = skills[i];
			else
				str = str + ',' + skills[i];
		}
		String sql = "Insert into registration_manager values(?,?,?,?,?,?,?)";
		int update = template.update(sql, manager.getFirstName(), manager.getLastName(), Long.parseLong(manager.getContactNo()),
				manager.getEmail(), manager.getPassword(), java.sql.Date.valueOf(manager.getDob()),str);
		return update;
	}

	@Override
	public boolean validate(Manager manager) {
		String password="";
		String query = "select password from registration_manager where email=?"; 
        Object[] inputs = new Object[] {manager.getEmail()};
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
		String sql = "Select * from registration_manager where email=?";
		Manager manager1 = template.queryForObject(sql, new Object[] { manager.getEmail() },
				new BeanPropertyRowMapper<Manager>(Manager.class));
		if (manager1.getPassword().equals(manager.getPassword()))
			return true;
		else
			return false;
	}}

	@Override
	public boolean validateEmail(Manager manager) {
		String sql="Select * from registration_manager where email=?";
		try {
		Manager manager1= template.queryForObject(sql, new Object[] { manager.getEmail() }, new BeanPropertyRowMapper<Manager>(Manager.class));
		if(manager1==null)
			return true;
		else
			return false;}
		catch(Exception e)
		{
			return true;
		}}
}
