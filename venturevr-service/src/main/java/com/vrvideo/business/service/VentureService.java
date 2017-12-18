package com.vrvideo.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrvideo.business.domain.VentureDetails;
import com.vrvideo.data.entity.Account;
import com.vrvideo.data.entity.Establishment;
import com.vrvideo.data.entity.Video;
import com.vrvideo.data.repository.AccountRepository;
import com.vrvideo.data.repository.EstablishmentRepository;
import com.vrvideo.data.repository.UserRepository;
import com.vrvideo.data.repository.VideoRepository;

@Service
public class VentureService {
	
	private EstablishmentRepository estRepo;
	private VideoRepository videoRepo;
    private AccountRepository accRepo;
    
    @Autowired
	public VentureService(EstablishmentRepository estRepo, VideoRepository videoRepo, UserRepository userRepo, AccountRepository accRepo) {
		this.estRepo = estRepo;
		this.videoRepo = videoRepo;
		this.accRepo = accRepo;
	}
	
	public VentureDetails getVentureDetailsByAccId(Long accId){
		
		Establishment estData = this.estRepo.findEstablishmentByUserId(accId);
		Account accData = this.accRepo.findAccountByAccId(accId); 
		List<Video>videoList =new ArrayList<Video>();
		
		videoList = this.videoRepo.findAllVideosByEstId(estData.getEstId());
		
		   
		
		VentureDetails ventureData = new VentureDetails(accData.getAccId(), estData.getEstId(), 
				estData.getEstAbout(), accData.getFirstName(), accData.getLastName(), estData.getEstCreated(), videoList); 
		
		return ventureData;
		
	}
	
	 
 /*   @RequestMapping(method= RequestMethod.POST, value="/userlogin")
    public Account login(@PathVariable(value="username")String username,
    		@PathVariable(value="password")String password){
        return this.accountRepo.findAccountByUsernameAndPassword(username, password);
    }*/
	
}
