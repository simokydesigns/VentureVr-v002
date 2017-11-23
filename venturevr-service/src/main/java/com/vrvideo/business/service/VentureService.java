package com.vrvideo.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrvideo.business.domain.VentureDetails;
import com.vrvideo.data.entity.Establishment;
import com.vrvideo.data.entity.User;
import com.vrvideo.data.entity.Video;
import com.vrvideo.data.repository.EstablishmentRepository;
import com.vrvideo.data.repository.UserRepository;
import com.vrvideo.data.repository.VideoRepository;

@Service
public class VentureService {
	
	private EstablishmentRepository estRepo;
	private VideoRepository videoRepo;
    private UserRepository userRepo;
    private List<Video> allVideosList;
	
	@Autowired
	public VentureService(EstablishmentRepository estRepo, VideoRepository videoRepo, UserRepository userRepo) {
		this.estRepo = estRepo;
		this.videoRepo = videoRepo;
		this.userRepo = userRepo;
	}
	
	public VentureDetails getVentureDetailsByUserId(Long userId){
		
		Establishment estData = this.estRepo.findEstablishmentByUserId(userId);
		User userData = this.userRepo.findByUserId(userId); 
		List<Video>videoList =new ArrayList<Video>();
		
		videoList = this.videoRepo.findAllVideosByEstId(estData.getEstId());
		
		   
		
		VentureDetails ventureData = new VentureDetails(userData.getUserId(), estData.getEstId(), 
				estData.getEstAbout(), userData.getFirstName(), userData.getLastName(), estData.getEstCreated(), videoList); 
		
		return ventureData;
		
	}
	
}
