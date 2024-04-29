package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.PolicyNotFoundException;
import com.model.Policy;
import com.utility.DBConnection;

public class PolicyDaoImpl implements PolicyDao{

	@Override
	public int insertPolicy(Policy p) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO policy(name, premium, rate_of_interest) VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, p.getName());
		pstmt.setDouble(2, p.getPremium());
		pstmt.setInt(3, p.getRateOfInterest());
		
		int status = pstmt.executeUpdate();
	
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public List<Policy> getAllPolicies() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from policy";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Policy> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			String name = rst.getString("name");
			double premium = rst.getDouble("premium");
			int rateOfInterest = rst.getInt("rate_of_interest");
			String isActive = rst.getString("active");
			
			Policy p = new Policy(id, name, premium, rateOfInterest, isActive);
			list.add(p);
		}
		
		DBConnection.dbClose();
		return list;
	}

	@Override
	public Policy getPolicyById(int policyId) throws SQLException, PolicyNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from policy where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			int id = rst.getInt("id");
			String name = rst.getString("name");
			double premium = rst.getDouble("premium");
			int rateOfInterest = rst.getInt("rate_of_interest");
			String isActive = rst.getString("active");
			
			Policy p = new Policy(id, name, premium, rateOfInterest, isActive);
			return p;
		}
		DBConnection.dbClose();
		return null;
		
	}

	@Override
	public int updatePolicyData(int policyId, String newName, double newPremium, int newInterest) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE policy SET name=?, premium=?, rate_of_interest=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newName);
		pstmt.setDouble(2, newPremium);
		pstmt.setInt(3, newInterest);
		pstmt.setInt(4, policyId);
		int status = pstmt.executeUpdate();
		return status;
	}

	@Override
	public int deactivatePolicy(int policyId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE policy SET active='NO' WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId);
		int status = pstmt.executeUpdate();
		return status;
	}

	@Override
	public int activatePolicy(int policyId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE policy SET active='YES' WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId);
		int status = pstmt.executeUpdate();
		return status;
	}

}
