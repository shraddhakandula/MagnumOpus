package com.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.dbutility.DBConnection;
import com.mo.dto.User;

public class UserDAO {
	
	
	public int add(User user){
		final String INSERT_QUERY="insert into user(id,name,department,email,role,password,noOfArts,year) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
			Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getDepartment());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getRole());
			pst.setString(6, user.getPassword());
			pst.setInt(7, user.getNoOfArts());
			pst.setInt(8, user.getYear());
			
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	


public List<User> getAllUsers(){
	List<User> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from user ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		User user=new User();
		user.setId(rst.getString(1));
		user.setName(rst.getString(2));
		user.setDepartment(rst.getString(3));
		user.setYear(rst.getInt(4));
		user.setPassword(rst.getString(5));
		user.setEmail(rst.getString(6));
		user.setNoOfArts(rst.getInt(7));
		user.setYear(rst.getInt(8));
		list.add(user);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public int editUser(User user) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update user set name = ?,department = ?,email = ?,role = ?,password = ?,noOfArts = ?,year = ?where id = ?");
		pst.setString(1, user.getId());
		pst.setString(2, user.getName());
		pst.setString(3, user.getDepartment());
		pst.setString(4, user.getEmail());
		pst.setString(5, user.getRole());
		pst.setString(6, user.getPassword());
		pst.setInt(7, user.getNoOfArts());
		pst.setInt(8, user.getYear());
					
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+user);
	} catch (SQLException e) {				
		e.printStackTrace();
	}	
	finally{
		try {
			con.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}
	return x;
}


public User getUser(String id) {
	PreparedStatement pst = null;
	ResultSet rst = null;
	User user=null;
final String SELECT_QUERY = "select * from user where id = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setString(1, id);
	rst = pst.executeQuery();
	if(rst.next()){
		user=new User();
		user.setId(rst.getString(1));
		user.setName(rst.getString(2));
		user.setDepartment(rst.getString(3));
		user.setYear(rst.getInt(4));
		user.setPassword(rst.getString(5));
		user.setEmail(rst.getString(6));
		user.setNoOfArts(rst.getInt(7));
		user.setYear(rst.getInt(8));
	System.out.println(user);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return user;
}
}