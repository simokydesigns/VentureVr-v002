package com.vrvideo.data.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class holding information on a User.
 */
@Entity
@Table(name = "user")

public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
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
	

	public User(String lastName, String firstName, String address, String contactNo, String email, String bio) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.bio = bio;
	}
	
	public User() {
		super();
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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


	@Override
	public String toString() {
		return "User [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", address=" + address
				+ ", contactNo=" + contactNo + ", email=" + email + ", bio=" + bio + "]";
	}
 
}

