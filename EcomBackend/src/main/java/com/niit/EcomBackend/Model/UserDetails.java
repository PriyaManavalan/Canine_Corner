package com.niit.EcomBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "UserDetails")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	@Column(nullable = false)
	@NotEmpty(message = "required")
	String userName;
	@Column(nullable = false, unique = true)
	@NotEmpty(message = "required")
	String useremailId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUseremailId() {
		return useremailId;
	}
	public void setUseremailId(String useremailId) {
		this.useremailId = useremailId;
	}
	public String getUserPhno() {
		return userPhno;
	}
	public void setUserPhno(String userPhno) {
		this.userPhno = userPhno;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Column(nullable = false)
	@NotEmpty(message = "required")
	String userPhno;
	@Column(nullable = false, unique = true)
	@NotEmpty(message = "required")
	String userPassword;
	
}
