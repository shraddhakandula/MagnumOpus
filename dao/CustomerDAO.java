package com.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.dbutility.DBConnection;
import com.mo.dto.Customer;


public class CustomerDAO {
	
	
	public int add(Customer customer){
		final String INSERT_QUERY="insert into customer(id, name, email, password, mobile, flat, street, colony, area, landmark) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
			Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, customer.getId());	
			pst.setString(2, customer.getName());
			pst.setString(3, customer.getEmail());
			pst.setString(4, customer.getPassword());
			pst.setString(5, customer.getMobile());
			pst.setString(6, customer.getFlat());
			pst.setString(7, customer.getStreet());
			pst.setString(8, customer.getColony());
			pst.setString(9, customer.getArea());
			pst.setString(10, customer.getLandmark());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
public Customer getCustomer(String id){
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	Customer customer=null;
final String SELECT_QUERY = "select * from customer where id = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setString(1, id);
	rst = pst.executeQuery();
	if(rst.next()){
		customer=new Customer();
		customer.setId(rst.getString(1));
		customer.setName(rst.getString(2));
		customer.setEmail(rst.getString(3));
		customer.setPassword(rst.getString(4));
		customer.setMobile(rst.getString(5));
		customer.setFlat(rst.getString(6));
		customer.setStreet(rst.getString(7));
		customer.setColony(rst.getString(8));
		customer.setArea(rst.getString(9));
		customer.setLandmark(rst.getString(10));
	System.out.println(customer);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return customer;
}


public List<Customer> getAllCustomer(){
	List<Customer> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from customer ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		Customer customer=new Customer();
		customer.setId(rst.getString(1));
		customer.setName(rst.getString(2));
		customer.setEmail(rst.getString(3));
		customer.setPassword(rst.getString(4));
		customer.setMobile(rst.getString(5));
		customer.setFlat(rst.getString(6));
		customer.setStreet(rst.getString(7));
		customer.setColony(rst.getString(8));
		customer.setArea(rst.getString(9));
		customer.setLandmark(rst.getString(10));
		list.add(customer);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public int editCustomer(Customer customer) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update customer set name = ?, email = ?, password = ?, mobileNumber = ?, flat = ?, street = ?, colony = ?, area = ?, landmark = ? where id = ?");
		pst.setString(1, customer.getId());	
		pst.setString(2, customer.getName());
		pst.setString(3, customer.getEmail());
		pst.setString(4, customer.getPassword());
		pst.setString(5, customer.getMobile());
		pst.setString(6, customer.getFlat());
		pst.setString(7, customer.getStreet());
		pst.setString(8, customer.getColony());
		pst.setString(9, customer.getArea());
		pst.setString(10, customer.getLandmark());
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+customer);
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
public Customer getCustomer(int id) {
	PreparedStatement pst = null;
	ResultSet rst = null;
	Customer customer=null;
final String SELECT_QUERY = "select * from customer where id = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, id);
	rst = pst.executeQuery();
	if(rst.next()){
		customer=new Customer();
		customer.setId(rst.getString(1));
		customer.setName(rst.getString(2));
		customer.setEmail(rst.getString(3));
		customer.setPassword(rst.getString(4));
		customer.setMobile(rst.getString(5));
		customer.setFlat(rst.getString(6));
		customer.setStreet(rst.getString(7));
		customer.setColony(rst.getString(8));
		customer.setArea(rst.getString(9));
		customer.setLandmark(rst.getString(10));
	System.out.println(customer);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return customer;
}
}