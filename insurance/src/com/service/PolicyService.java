package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Policy;

import com.dao.PolicyDao;
import com.dao.PolicyDaoImpl;
import com.exception.PolicyNotFoundException;

public class PolicyService {
	PolicyDao dao = new PolicyDaoImpl();

	public int insertPolicy(Policy p) throws SQLException{
		return dao.insertPolicy(p);
	}

	public List<Policy> getAll() throws SQLException{
		return dao.getAllPolicies();
	}

	public Policy getPolicyById(int policyId) throws SQLException, PolicyNotFoundException{
		return dao.getPolicyById(policyId);
	}

	public int updatePolicyData(int policyId, String newName, double newPremium, int newInterest) throws SQLException {
		return dao.updatePolicyData(policyId, newName, newPremium, newInterest);
	}

	public int deactivatePolicy(int policyId) throws SQLException {
		return dao.deactivatePolicy(policyId);
	}

	public int activatePolicy(int policyId) throws SQLException{
		return dao.activatePolicy(policyId);
	}

}
