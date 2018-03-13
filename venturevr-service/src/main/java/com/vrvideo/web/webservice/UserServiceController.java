package com.vrvideo.web.webservice;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrvideo.config.AuthorizationConfig;
import com.vrvideo.data.entity.User;
import com.vrvideo.data.repository.UserRepository;

@RestController
@RequestMapping(value="/api")
public class UserServiceController{
	


	    @Autowired
	    private UserRepository userRepo;
        
	
	    @RequestMapping(method= RequestMethod.GET, value="/users/{userId}")
	    public User getUserById(@PathVariable(value="userId")Long userId){
	    	
	    		return this.getUserById(userId);
	    };
	    
	    @RequestMapping(method= RequestMethod.GET, value="/users")
	    public Iterable<User> getAllUsers(){
	        return this.userRepo.findAll();
	    }
	    
	    @RequestMapping(method= RequestMethod.POST, consumes = "application/json", value="/newuser")
	    @ResponseBody
	    public void addNewUser(@RequestBody User newUser){
	    	AuthorizationConfig encoder = new AuthorizationConfig();
			String hashedPassword = encoder.passwordEncoder().encode(newUser.getPassword());
	    	userRepo.save(new User(newUser.getUsername(), hashedPassword, true));	    	
	    }
	    
	    @RequestMapping(method= RequestMethod.GET, value="/userlogin/{username}")
	    public User getUserByUsername(@PathVariable(value="username")String username, Principal principal){
	    
	    	User currentUser = userRepo.findOneByUsername(principal.getName());
	    	
	    	if(currentUser.getUsername().equals(username)) {
	    	
	        return currentUser;
	        
	    	}else
	    		
	    	return null;
	    };
}
