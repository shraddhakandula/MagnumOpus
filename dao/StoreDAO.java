package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Store;

public class StoreDAO {
	
	
	public int add(Store store){
		final String INSERT_QUERY="insert into store(productId,typeOfArt,price,description) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
			Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, store.getProductId());
			pst.setString(2, store.getTypeOfArt());
			pst.setInt(3, store.getPrice());
			pst.setString(4, store.getDescription());			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
public Store getStore(int productId){
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	Store store=null;
final String SELECT_QUERY = "select * from store where productId = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, productId);
	rst = pst.executeQuery();
	if(rst.next()){
		 store=new Store();
		 store.setProductId(rst.getInt(1));
		 store.setTypeOfArt(rst.getString(2));
		 store.setPrice(rst.getInt(3));
		 store.setDescription(rst.getString(4));
	System.out.println(store);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return store;
}


public List<Store> getAllStores(){
	List<Store> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from store ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		Store store=new Store();
		store.setProductId(rst.getInt(1));
		store.setTypeOfArt(rst.getString(2));
		store.setPrice(rst.getInt(3));
		store.setDescription(rst.getString(4));
		list.add(store);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public int editStore(Store store) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update store set productId = ?,typeOfArt = ?,price = ?,description = ? where productId = ?");
		pst.setInt(1, store.getProductId());
		pst.setString(2, store.getTypeOfArt());
		pst.setInt(3, store.getPrice());
		pst.setString(4, store.getDescription());					
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+store);
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