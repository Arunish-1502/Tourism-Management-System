package com.cts.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.packageDetails;

@Service
public interface packageListDao {
	public List<packageDetails> extractPackages() throws SQLException;
	public void deletePackage(int id) throws SQLException;
	public int addPackage(packageDetails packageDetails) throws SQLException;
	public void updatePackage(packageDetails details) throws SQLException;
	public packageDetails retrievePackage(int id) throws SQLException;
}
