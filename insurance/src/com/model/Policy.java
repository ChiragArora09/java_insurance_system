package com.model;

public class Policy {
	private int id;
	private String name;
	private double premium;
	private int rateOfInterest;
	private String isActive;
	
	public Policy(int id, String name, double premium, int rateOfInterest, String isActive) {
		super();
		this.id = id;
		this.name = name;
		this.premium = premium;
		this.rateOfInterest = rateOfInterest;
		this.isActive = isActive;
	}

	public Policy(String name, double premium, int rateOfInterest) {
		super();
		this.name = name;
		this.premium = premium;
		this.rateOfInterest = rateOfInterest;
	}


	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public int getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(int rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "Policy [id=" + id + ", name=" + name + ", premium=" + premium + ", rateOfInterest=" + rateOfInterest
				+ "]";
	}
	
}
