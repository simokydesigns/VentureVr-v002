package com.vrvideo.web.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrvideo.data.entity.User;
import com.vrvideo.data.repository.UserRepository;



@RestController
@RequestMapping(value="/api")
public class UserServiceController {
	


	    @Autowired
	    private UserRepository userRepo;

	    @CrossOrigin
	    @RequestMapping(method= RequestMethod.GET, value="/users/{userId}")
	    public User getAllUsersById(@PathVariable(value="userId")Long userId){
	        return this.userRepo.findByUserId(userId);
	    };
	    
	    @CrossOrigin
	    @RequestMapping(method= RequestMethod.GET, value="/users")
	    public Iterable<User> getAllUsers(){
	        return this.userRepo.findAll();
	    }
	    
	    @RequestMapping(method= RequestMethod.POST, consumes = "application/json", value="/newuser")
	    @ResponseBody
	    public void addNewUser(@RequestBody User newUser){
	   
	    	userRepo.save(new User(newUser.getAddress(), newUser.getLastName(), newUser.getFirstName(),
	    			newUser.getContactNo(), newUser.getEmail(), newUser.getBio()));	    	
	    }
}
