package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Order;

public class OrderDAO {
	
	
	public int add(Order order){
		final String INSERT_QUERY="insert into order(transactionId, paymentDate, quantity, finalAmount, status) values(?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
			Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1,  order.getTransactionId());
			pst.setDate(2, order.getPaymentDate());
			pst.setInt(3,order.getQuantity());
			pst.setInt(4, order.getFinalAmount());
			pst.setString(5,  order.getStatus());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
public Order getOrder(int transactionId){
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	Order order=null;
final String SELECT_QUERY = "select * from order where transactionId = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, transactionId);
	rst = pst.executeQuery();
	if(rst.next()){
		 order=new Order();
		 order.setTransactionId(rst.getInt(1));
		 order.setPaymentDate(rst.getDate(2));
		 order.setQuantity(rst.getInt(3));
		 order.setFinalAmount(rst.getInt(4));
		 order.setStatus(rst.getString(5));
	System.out.println(order);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return order;
}


public List<Order> getAllOrder(){
	List<Order> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from order ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		Order order=new Order();
		order.setTransactionId(rst.getInt(1));
		 order.setPaymentDate(rst.getDate(2));
		 order.setQuantity(rst.getInt(3));
		 order.setFinalAmount(rst.getInt(4));
		 order.setStatus(rst.getString(5));
		list.add(order);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public int editOrder(Order order) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update order set  paymentDate = ?, quantity = ?, finalAmount = ?, status = ? where transactionId = ?");
		pst.setInt(1,  order.getTransactionId());
		pst.setDate(2, order.getPaymentDate());
		pst.setInt(3,order.getQuantity());
		pst.setInt(4, order.getFinalAmount());
		pst.setString(5,  order.getStatus());
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+order);
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


}