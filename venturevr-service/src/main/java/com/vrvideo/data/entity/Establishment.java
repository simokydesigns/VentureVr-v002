package com.vrvideo.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class holding information on a Establishment.
 */
@Entity
@Table(name = "establishment")
public class Establishment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="est_id")
	private long estId;
	@Column(name="est_name")
	private String estName;
	@Column(name="location")
	private String location;
	@Column(name="address")
	private String address;
	@Column(name="est_type")
	private String estType;
	@Column(name="est_about")
	private String estAbout;
	@Column(name="est_img_name")
	private String estImgName;
	@Column(name="est_img_path")
	private String estImgPath;
	@Column(name="est_img_format")
	private String estImgFormat;
	@Column(name="user_id")
	private long userId;
	@Column(name="est_created")
	private String estCreated;

	
	
	public Establishment() {
		super();
	}

	public Establishment(String estName, String location, String address, String estType, String estAbout,
			String estImgName, String estImgPath, String estImgFormat, long userId, String estCreated) {
		super();
		this.estName = estName;
		this.location = location;
		this.address = address;
		this.estType = estType;
		this.estAbout = estAbout;
		this.estImgName = estImgName;
		this.estImgPath = estImgPath;
		this.estImgFormat = estImgFormat;
		this.userId = userId;
		this.estCreated = estCreated;
	}

	public long getEstId() {
		return estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public String getEstName() {
		return estName;
	}

	public void setEstName(String estName) {
		this.estName = estName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEstType() {
		return estType;
	}

	public void setEstType(String estType) {
		this.estType = estType;
	}

	public String getEstAbout() {
		return estAbout;
	}

	public void setEstAbout(String estAbout) {
		this.estAbout = estAbout;
	}

	public String getEstImgName() {
		return estImgName;
	}

	public void setEstImgName(String estImgName) {
		this.estImgName = estImgName;
	}

	public String getEstImgPath() {
		return estImgPath;
	}

	public void setEstImgPath(String estImgPath) {
		this.estImgPath = estImgPath;
	}

	public String getEstImgFormat() {
		return estImgFormat;
	}

	public void setEstImgFormat(String estImgFormat) {
		this.estImgFormat = estImgFormat;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEstCreated() {
		return estCreated;
	}

	public void setEstCreated(String estCreated) {
		this.estCreated = estCreated;
	}

	@Override
	public String toString() {
		return "Establishment [estId=" + estId + ", estName=" + estName + ", location=" + location + ", address="
				+ address + ", estType=" + estType + ", estAbout=" + estAbout + ", estImgName=" + estImgName
				+ ", estImgPath=" + estImgPath + ", estImgFormat=" + estImgFormat + ", userId=" + userId
				+ ", estCreated=" + estCreated + "]";
	}

}
