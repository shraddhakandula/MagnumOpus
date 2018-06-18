package com.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.dbutility.DBConnection;
import com.mo.dto.Art;

public class ArtDAO {
	
	
	public int add(Art art){
		final String INSERT_QUERY="insert into art(id,name,rollNo,quote,likes,store,typeOfArt) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
			Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, art.getId());
			pst.setString(2, art.getName());
			pst.setString(3, art.getRollNo());
			pst.setString(4, art.getQuote());
			pst.setInt(5, art.getLikes());
			pst.setString(6, art.getStore());
			pst.setString(7, art.getTypeOfArt());			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
public Art getArt(int id){
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	Art art=null;
final String SELECT_QUERY = "select * from art where id = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, id);
	rst = pst.executeQuery();
	if(rst.next()){
		 art=new Art();
		 art.setId(rst.getInt(1));
		 art.setName(rst.getString(2));
		 art.setRollNo(rst.getString(3));
		 art.setQuote(rst.getString(4));
		 art.setLikes(rst.getInt(5));
		 art.setStore(rst.getString(6));
		 art.setTypeOfArt(rst.getString(7));
	System.out.println(art);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return art;
}


public List<Art> getAllArt(){
	List<Art> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from art ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		Art art=new Art();
		art.setId(rst.getInt(1));
		art.setName(rst.getString(2));
		art.setRollNo(rst.getString(3));
		art.setQuote(rst.getString(4));
		art.setLikes(rst.getInt(5));
		art.setStore(rst.getString(6));
		art.setTypeOfArt(rst.getString(7));
		list.add(art);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public int editArt(Art art) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update art set name = ?,rollNo = ?,quote = ?,likes = ?,store = ?,typeOfArt = ? where artId = ?");
		pst.setInt(1, art.getId());
		pst.setString(2, art.getName());
		pst.setString(3, art.getRollNo());
		pst.setString(4, art.getQuote());
		pst.setInt(5, art.getLikes());
		pst.setString(6, art.getStore());
		pst.setString(7, art.getTypeOfArt());
					
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+art);
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