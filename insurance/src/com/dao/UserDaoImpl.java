package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.InvalidCredentialsException;
import com.model.User;
import com.utility.DBConnection;

public class UserDaoImpl implements UserDao{

	@Override
	public String save(User user) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO user(username, password, role) VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getRole());
		
		int status = pstmt.executeUpdate();
	
		DBConnection.dbClose();		
		
		if(status == 1) {
			return user.getUsername();
		} else {
			return null;
		}
	}

	@Override
	public int getId(String createdUsername) throws SQLException {
		int userId = -1;
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT id FROM user WHERE username='"+createdUsername+"'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet id = pstmt.executeQuery();
		while(id.next()) {
			userId = id.getInt("id");
		}
		id.close();
		DBConnection.dbClose();
		return userId;
		
	}

	@Override
	public User loginUser(String username, String loginPassword) throws SQLException, InvalidCredentialsException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from user WHERE username=? AND password=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, loginPassword);
		ResultSet rst  = pstmt.executeQuery();
		User userObj= new User();
		while(rst.next()) {
			String loggedInUsername = rst.getString("username");
			userObj.setUsername(loggedInUsername);
			String password = "encrypted";
			userObj.setPassword(password);
			String role = rst.getString("role");
			userObj.setRole(role);
			int id = rst.getInt("id");
			userObj.setId(id);			
		}
		DBConnection.dbClose();
		return userObj;
	}
	
	
}
