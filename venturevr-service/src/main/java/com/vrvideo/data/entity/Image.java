package com.vrvideo.data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Class holding information on a video.
 */
@Entity
@Table(name = "image")

public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="img_id")
	private long videoId;
	@Column(name="img_name")
	private String imgName;
	@Column(name="img_path")
	private String imgPath;
	@Column(name="img_type")
	private String imgType;
	@Column(name="est_id")
	private long estId;
	@Column(name="uploaded_date")
	private Timestamp uploadedDate;
	
	public Image() {
		super();
	}

	public Image(String imgName, String imgPath, String imgType, long estId) {
		super();
		this.imgName = imgName;
		this.imgPath = imgPath;
		this.imgType = imgType;
		this.estId = estId;
	}

	public long getVideoId() {
		return videoId;
	}

	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public long getEstId() {
		return estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public Timestamp getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Timestamp uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	@Override
	public String toString() {
		return "Image [videoId=" + videoId + ", imgName=" + imgName + ", imgPath=" + imgPath + ", imgType=" + imgType
				+ ", estId=" + estId + ", uploadedDate=" + uploadedDate + "]";
	}

}

