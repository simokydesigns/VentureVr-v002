package com.vrvideo.business.domain;

import com.vrvideo.data.entity.Video;

import antlr.collections.List;


public class VentureDetails {
	
    private long userId;
    private long estId;
    private String estAbout;
    private String firstName;
    private String lastName;
    private String estCreated;
    private Iterable<Video>allVideos;
    
	public VentureDetails(long userId, long estId, String estAbout, String firstName, String lastName,
			String estCreated, Iterable<Video>allVideos) {
		super();
		this.userId = userId;
		this.estId = estId;
		this.estAbout = estAbout;
		this.firstName = firstName;
		this.lastName = lastName;
		this.estCreated = estCreated;
		this.allVideos = allVideos;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEstId() {
		return estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public String getEstAbout() {
		return estAbout;
	}

	public void setEstAbout(String estAbout) {
		this.estAbout = estAbout;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEstCreated() {
		return estCreated;
	}

	public void setEstCreated(String estCreated) {
		this.estCreated = estCreated;
	}

	public Iterable<Video> getAllVideos() {
		return allVideos;
	}

	public void setAllVideos(Iterable<Video> allVideos) {
		this.allVideos = allVideos;
	}
 
}
