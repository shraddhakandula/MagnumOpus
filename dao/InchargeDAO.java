package com.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.dbutility.DBConnection;
import com.mo.dto.Incharge;

public class InchargeDAO {
	
	
	public int add(Incharge incharge){
		final String INSERT_QUERY="insert into incharge(id,name,department,year,password,email) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, incharge.getId());
			pst.setString(2, incharge.getName());
			pst.setString(3, incharge.getDepartment());
			pst.setInt(4, incharge.getYear());
			pst.setString(5, incharge.getPassword());
			pst.setString(6, incharge.getEmail());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
public List<Incharge> getAllIncharge(){
	List<Incharge> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from incharge ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		Incharge incharge=new Incharge();
		incharge.setId(rst.getString(1));
		incharge.setName(rst.getString(2));
		incharge.setDepartment(rst.getString(3));
		incharge.setYear(rst.getInt(4));
		incharge.setPassword(rst.getString(5));
		incharge.setEmail(rst.getString(6));
		list.add(incharge);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public int editIncharge(Incharge incharge) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update incharge set name = ?,department = ?,year = ?,password = ?,email = ? where id = ?");
		pst.setString(1, incharge.getId());
		pst.setString(2, incharge.getName());
		pst.setString(3, incharge.getDepartment());
		pst.setInt(4, incharge.getYear());
		pst.setString(5, incharge.getPassword());
		pst.setString(6, incharge.getEmail());
					
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+incharge);
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


public Incharge getIncharge(int id) {
	PreparedStatement pst = null;
	ResultSet rst = null;
	Incharge incharge=null;
final String SELECT_QUERY = "select * from incharge where id = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, id);
	rst = pst.executeQuery();
	if(rst.next()){
		incharge=new Incharge();
		 incharge.setId(rst.getString(1));
		 incharge.setName(rst.getString(2));
		 incharge.setDepartment(rst.getString(3));
		 incharge.setYear(rst.getInt(4));
		 incharge.setPassword(rst.getString(5));
		 incharge.setEmail(rst.getString(6));
	System.out.println(incharge);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return incharge;
}
}