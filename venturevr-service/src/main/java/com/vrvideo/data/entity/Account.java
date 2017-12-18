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
	@Column(name="last_name")
	private String lastName;
	@Column(name="first_name")
	private String firstName;
	@Column(name="address")
	private String address;
	@Column(name="contact_no")
	private String contactNo;
	@Column(name="email")
	private String email;
	@Column(name="bio")
	private String bio;
	@Column(name="user_name")
	private String username;
	@Column(name="acc_details")
	private String accDetails;
	@Column(name="date_account_created")
	private Timestamp dateAccountCreated;
	
	public Account() {
		super();
	}

	public Account(String lastName, String firstName, String address, String contactNo, String email, String bio,
			String username, String accDetails) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.bio = bio;
		this.username = username;
		this.accDetails = accDetails;
	}

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "Account [accId=" + accId + ", lastName=" + lastName + ", firstName=" + firstName + ", address="
				+ address + ", contactNo=" + contactNo + ", email=" + email + ", bio=" + bio + ", username=" + username
				+ ", accDetails=" + accDetails + ", dateAccountCreated=" + dateAccountCreated + "]";
	}
	
}
