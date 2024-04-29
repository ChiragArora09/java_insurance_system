package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.PolicyNotFoundException;
import com.model.Policy;

public interface PolicyDao {

	int insertPolicy(Policy p) throws SQLException;

	List<Policy> getAllPolicies() throws SQLException;

	Policy getPolicyById(int policyId) throws SQLException, PolicyNotFoundException;

	int updatePolicyData(int policyId, String newName, double newPremium, int newInterest) throws SQLException;

	int deactivatePolicy(int policyId) throws SQLException;

	int activatePolicy(int policyId) throws SQLException;

}
