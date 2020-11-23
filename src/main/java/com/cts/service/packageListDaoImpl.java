package com.cts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.cts.model.packageDetails;
import com.cts.dao.ConnectionDriver;
import com.cts.dao.packageListDao;
import com.cts.model.packageDetails;

@Configuration
public class packageListDaoImpl implements packageListDao {
	
	public List<packageDetails> extractPackages() throws SQLException{
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st = con.prepareStatement("select * from package_details");
		List<packageDetails> UserPackageDetailsList = new ArrayList<packageDetails>();
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
			packageDetails details = new packageDetails();
			details.setPackageId(rs.getInt(1));
			details.setPackageName(rs.getString(2));
			details.setLocation(rs.getString(3));
			details.setDuration(rs.getString(4));
			details.setPackageCost(rs.getInt(5));
			UserPackageDetailsList.add(details);
		}
		return UserPackageDetailsList;
	}
	
	public void deletePackage(int id) throws SQLException {
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st = con.prepareStatement("delete from package_details where package_id="+id);
		st.executeUpdate();
	}
	
	public int addPackage(packageDetails packageDetails) throws SQLException {
		Connection con=ConnectionDriver.getConn();
		String insertString="insert into package_details values(?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(insertString);
		st.setInt(1, packageDetails.generatePackageId());
		st.setString(2, packageDetails.getPackageName());
		st.setString(3,packageDetails.getLocation());
		st.setString(4, packageDetails.getDuration());
		st.setInt(5, packageDetails.getPackageCost());
		int k=st.executeUpdate();
		return k;
	}
	
	public void updatePackage(packageDetails packageDetails) throws SQLException {
		String updateSQL="update package_details set package_name=?, location=?, duration=?, package_cost=? where package_id=?";
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st=con.prepareStatement(updateSQL);
		st.setString(1, packageDetails.getPackageName());
		st.setString(2,packageDetails.getLocation());
		st.setString(3, packageDetails.getDuration());
		st.setInt(4, packageDetails.getPackageCost());
		st.setInt(5, packageDetails.getPackageId());
		int k=st.executeUpdate();
	}
	
	public packageDetails retrievePackage(int id) throws SQLException {
		List<packageDetails> list= extractPackages();
			for(packageDetails details: list)
			{
				if (details.getPackageId()==id) {
					return details;
			}}
			return null;
		
		}
}
