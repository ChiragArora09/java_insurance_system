package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Client;
import com.utility.DBConnection;

public class ClientDaoImpl implements ClientDao{

	@Override
	public int save(Client c1) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO client(client_name, contact_info, user_id) VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, c1.getClient_name());
		pstmt.setString(2, c1.getContact_info());
		pstmt.setInt(3, c1.getUser_id());
		
		int status = pstmt.executeUpdate();
	
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public Client getClientById(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from client WHERE user_id="+id;
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		
		Client c1 = new Client();
		if(rst.next()) {
			c1.setId(rst.getInt("id"));
			c1.setClient_name(rst.getString("client_name"));
			c1.setContact_info(rst.getString("contact_info"));
			c1.setUser_id(rst.getInt("user_id"));
		}
		
		DBConnection.dbClose();
		return c1;

	}
	

}
