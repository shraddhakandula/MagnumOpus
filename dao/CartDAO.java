package com.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.dbutility.DBConnection;
import com.mo.dto.Cart;

public class CartDAO {
	
	
	public int add(Cart cart){
		final String INSERT_QUERY="insert into cart(price,quantity) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
			Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, cart.getPrice());
			pst.setInt(2, cart.getQuantity());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
public Cart getCart(String tansactionId){
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	Cart cart=null;
final String SELECT_QUERY = "select * from cart where transactionId = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setString(5, tansactionId);
	rst = pst.executeQuery();
	if(rst.next()){
		 cart=new Cart();
		 cart.setPrice(rst.getInt(1));
		 cart.setQuantity(rst.getInt(2));
	System.out.println(cart);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return cart;
}


public List<Cart> getAllCarts(){
	List<Cart> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from cart ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		Cart cart=new Cart();
		cart.setPrice(rst.getInt(1));
		 cart.setQuantity(rst.getInt(2));
		list.add(cart);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public int editCart(Cart cart) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update cart set price = ?,quantity = ? where transactionId = ?");
		pst.setInt(1, cart.getPrice());
		pst.setInt(2, cart.getQuantity());
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+cart);
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