package com.vrvideo.data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class holding information on a Account.
 */
@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acc_id")
	private long accId;
	@Column(name="user_id")
	private String userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="acc_details")
	private String accDetails;
	@Column(name="date_account_created")
	private Timestamp dateAccountCreated;
	
	public Account() {
		super();
	}

	

	public Account(String userId, String userName, String password, String accDetails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.accDetails = accDetails;
	}



	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccDetails() {
		return accDetails;
	}

	public void setAccDetails(String accDetails) {
		this.accDetails = accDetails;
	}

	public Timestamp getDateAccountCreated() {
		return dateAccountCreated;
	}

	public void setDateAccountCreated(Timestamp dateAccountCreated) {
		this.dateAccountCreated = dateAccountCreated;
	}


	@Override
	public String toString() {
		return "Account [accId=" + accId + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", accDetails=" + accDetails + ", dateAccountCreated=" + dateAccountCreated + "]";
	}
	
}
