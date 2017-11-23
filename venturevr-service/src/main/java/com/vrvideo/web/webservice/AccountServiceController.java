package com.vrvideo.web.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

		    @CrossOrigin
		    @RequestMapping(method= RequestMethod.GET, value="/account/{accId}")
		    public Account getAccountByUserId(@PathVariable(value="userId")Long userId){
		        return this.accountRepo.findAccountByUserId(userId);
		    };
		    
		    @CrossOrigin
		    @RequestMapping(method= RequestMethod.GET, value="/accs")
		    public Iterable<Account> getAllAccounts(){
		        return this.accountRepo.findAll();
	};
	
    @RequestMapping(method= RequestMethod.POST, consumes = "application/json", value="/newacc")
    @ResponseBody
    public void addNewAccount(@RequestBody Account newAccount){
   
    	accountRepo.save(new Account(newAccount.getUserId(), newAccount.getUserName(), newAccount.getPassword(), newAccount.getAccDetails()));	    	
    }
}
