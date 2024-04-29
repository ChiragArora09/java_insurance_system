package com.service;

import java.sql.SQLException;

import com.model.Client;
import com.dao.ClientDao;
import com.dao.ClientDaoImpl;

public class ClientService {
	ClientDao dao = new ClientDaoImpl();

	public int insert(Client c1) throws SQLException{
		return dao.save(c1);
	}

	public Client getClient(int id) throws SQLException{
		return dao.getClientById(id);
	}

}
