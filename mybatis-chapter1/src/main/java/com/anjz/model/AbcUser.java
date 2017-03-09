package com.anjz.model;

public class AbcUser {
	
	private Integer id;
	
	/**
	 * user_name
	 */
	private java.lang.String userName;
	/**
	 * password
	 */
	private java.lang.String password;
	
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getUserName() {
		return this.userName;
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
		return "AbcUser [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}