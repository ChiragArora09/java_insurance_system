package com.dao;

import java.sql.SQLException;

import com.model.Client;

public interface ClientDao {

	int save(Client c1) throws SQLException;

	Client getClientById(int id)throws SQLException;

}
