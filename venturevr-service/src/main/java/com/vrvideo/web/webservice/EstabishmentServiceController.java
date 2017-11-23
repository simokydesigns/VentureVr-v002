package com.vrvideo.web.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrvideo.data.entity.Establishment;
import com.vrvideo.data.repository.EstablishmentRepository;





@RestController
@RequestMapping(value="/api")
public class EstabishmentServiceController {
	


	    @Autowired
	    private EstablishmentRepository establishmentRepo;
	 
	    

	    @CrossOrigin
	    @RequestMapping(method= RequestMethod.GET, value="/est/{userId}")
	    public Establishment getAllEstablishmentsByUserId(@PathVariable(value="userId")Long userId){
	
	        return this.establishmentRepo.findEstablishmentByUserId(userId);
	    };
	    
	    
	    
	    @CrossOrigin
	    @RequestMapping(method= RequestMethod.GET, value="/est")
	    public Iterable<Establishment> getAllEstablishments(){
	        return this.establishmentRepo.findAll();
	    }
	    
	    @RequestMapping(method= RequestMethod.POST, consumes = "application/json", value="/newest")
	    @ResponseBody
	    public void addNewEstablishment(@RequestBody Establishment newEst){
	   
	    	establishmentRepo.save(new Establishment(newEst.getEstName(), newEst.getLocation(), newEst.getAddress(),
	    			newEst.getEstType(), newEst.getEstAbout(), newEst.getEstImgName(), newEst.getEstImgPath(),
	    			newEst.getEstImgFormat(), newEst.getUserId(), newEst.getEstCreated()));	    	
	    }
}
