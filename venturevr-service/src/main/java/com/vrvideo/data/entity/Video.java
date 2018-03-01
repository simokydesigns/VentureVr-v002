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
@Table(name = "video")

public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="video_id")
	private long videoId;
	@Column(name="video_title")
	private String title;
	@Column(name="genre")
	private String genre;
	@Column(name="path")
	private String path;
	@Column(name="file_type")
	private String fileType;
	@Column(name="est_id")
	private long estId;
	@Column(name="date_video_created")
	private Timestamp dateVideoCreated;
	
	public Video() {
		super();
	}
	
	public Video(String title, String genre, String path, String fileType, long estId) {
		super();
		this.title = title;
		this.genre = genre;
		this.path = path;
		this.fileType = fileType;
		this.estId = estId;
	}

	public long getVideoId() {
		return videoId;
	}

	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getEstId() {
		return estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public Timestamp getDateVideoCreated() {
		return dateVideoCreated;
	}

	public void setDateVideoCreated(Timestamp dateVideoCreated) {
		this.dateVideoCreated = dateVideoCreated;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", genre=" + genre + ", path=" + path + ", fileType="
				+ fileType + ", estId=" + estId + ", dateVideoCreated=" + dateVideoCreated + "]";
	}

}

