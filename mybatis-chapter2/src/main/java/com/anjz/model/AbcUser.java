package com.anjz.model;

public class AbcUser {
	
	private Integer id;
	
	/**
	 * user_name
	 */
	private java.lang.String user_name;
	/**
	 * password
	 */
	private java.lang.String password;
	
	

	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getPassword() {
		return this.password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbcUser [id=" + id + ", user_name=" + user_name + ", password=" + password + "]";
	}
}