package com.model;

public class Claim {
	private int id;
	private int clientId;
	private int policyId;
	private int claimNumber;
	private String dateFiled;
	private float claimAmount;
	private String status;
	
	public Claim(int id, int clientId, int policyId, int claimNumber, String dateFiled, float claimAmount,
			String status) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.policyId = policyId;
		this.claimNumber = claimNumber;
		this.dateFiled = dateFiled;
		this.claimAmount = claimAmount;
		this.status = status;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public int getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDateFiled() {
		return dateFiled;
	}

	public void setDateFiled(String dateFiled) {
		this.dateFiled = dateFiled;
	}

	public float getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(float claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", clientId=" + clientId + ", policyId=" + policyId + ", claimNumber=" + claimNumber
				+ ", dateFiled=" + dateFiled + ", claimAmount=" + claimAmount + ", status=" + status + "]";
	}

}
