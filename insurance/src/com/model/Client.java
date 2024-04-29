package com.model;

public class Client {
	private int id;
	private String client_name;
	private String contact_info;
	private int user_id;
	
	public Client(int id, String client_name, String contact_info, int user_id) {
		super();
		this.id = id;
		this.client_name = client_name;
		this.contact_info = contact_info;
		this.user_id = user_id;
	}	

	public Client(String client_name, String contact_info, int user_id) {
		super();
		this.client_name = client_name;
		this.contact_info = contact_info;
		this.user_id = user_id;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", client_name=" + client_name + ", contact_info=" + contact_info + ", user_id="
				+ user_id + "]";
	}			

}
