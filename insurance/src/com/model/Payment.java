package com.model;

public class Payment {
	private int id;
	private String date;
	private double amount;
	private String clientId;
	
	public Payment(int id, String date, double amount, String clientId) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.clientId = clientId;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", date=" + date + ", amount=" + amount + ", clientId=" + clientId + "]";
	}
			

}
