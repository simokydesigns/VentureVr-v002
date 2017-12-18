package com.vrvideo.web.webservice;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrvideo.data.entity.Account;
import com.vrvideo.data.repository.AccountRepository;


@RestController
@RequestMapping(value="/api")

     public class AccountServiceController {
		    @Autowired
		    private AccountRepository accountRepo;

		    
		    @RequestMapping(method= RequestMethod.GET, value="/account/{accId}")
		    public Account getAccountByAccountId(@PathVariable(value="accId")Long accId, Principal principal){
		    
		    	Account currentAcc = accountRepo.findByUsername(principal.getName());
		    	
		    	if(currentAcc.getAccId() == accId) {
		    	
		        return currentAcc;
		        
		    	}else
		    		
		    	return null;
		    };
		    
		/*    @RequestMapping(method= RequestMethod.GET, value="/userlogin/{username}")
		    public Account getAccountByAccountId(@PathVariable(value="username")String username, Principal principal){
		    
		    	Account currentAcc = accountRepo.findByUsername(principal.getName());
		    	
		    	if(currentAcc.getUsername().equals(username)) {
		    	
		        return currentAcc;
		        
		    	}else
		    		
		    	return null;
		    };*/
		    
		    @RequestMapping(value = "/{accId}", method = RequestMethod.DELETE)
		    public ResponseEntity<Void> deleteAccount(@PathVariable long accId, Principal principal) {
		    	Account currentAccount = accountRepo.findByUsername(principal.getName());
		    	
		    	if (currentAccount.getAccId() == accId) {
		    		accountRepo.delete(accId);
		    		return new ResponseEntity<Void>(HttpStatus.OK);
		    	} else {
		    		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		    	}
		    }
		    
		
		    @RequestMapping(method= RequestMethod.GET, value="/accs")
		    public Iterable<Account> getAllAccounts(){
		        return this.accountRepo.findAll();
	        };
	
		    @RequestMapping(method= RequestMethod.POST, consumes = "application/json", value="/newacc")
		    @ResponseBody
		    public void addNewAccount(@RequestBody Account newAccount){
		   
		    	accountRepo.save(new Account(newAccount.getFirstName(), newAccount.getLastName(), 
		    			newAccount.getAddress(), newAccount.getContactNo(), newAccount.getEmail(), 
		    			newAccount.getBio(), newAccount.getUsername(), newAccount.getAccDetails()));	    	
		    }
		    
}
