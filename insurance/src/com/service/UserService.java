package com.service;

import java.sql.SQLException;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.InvalidCredentialsException;
import com.model.User;

public class UserService {
	UserDao dao = new UserDaoImpl();

	public String insert(User user) throws SQLException {
			return dao.save(user);
	}

	public int getId(String createdUsername) throws SQLException{
		return dao.getId(createdUsername);
	}

	public User login(String username, String loginPassword) throws SQLException, InvalidCredentialsException{
		return dao.loginUser(username, loginPassword);
	}

}
