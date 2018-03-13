package com.vrvideo.web.webservice;

import java.security.Principal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.exceptions.MySQLDataException;
import com.vrvideo.data.entity.Account;
import com.vrvideo.data.entity.User;
import com.vrvideo.data.repository.AccountRepository;
import com.vrvideo.data.repository.UserRepository;

@RestController
@RequestMapping(value = "/api")

public class AccountServiceController {
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private UserRepository userRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/account/{username}")
	public Account getAccountByUsername(@PathVariable(value = "username") String username, Principal principal) {

		User currentUser = userRepo.findOneByUsername(principal.getName());

		Account currentAcc = accountRepo.findByUsername(currentUser.getUsername());

		if (currentAcc != null) {

			return currentAcc;

		} else

			return null;
	};

	@RequestMapping(value = "/delete/{accId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAccount(@PathVariable long accId, Principal principal) {
		
		Account currentAccount = accountRepo.findByUsername(principal.getName());

		if (currentAccount.getAccId() == accId) {
			accountRepo.delete(accId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	};

	@RequestMapping(method = RequestMethod.GET, value = "/accs")
	public Iterable<Account> getAllAccounts() {
		return this.accountRepo.findAll();
	};


	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/acc/{username}")
	@ResponseBody
	public void editAccount(@RequestBody Account editAccount, Principal principal) throws SQLException {

		User currentUser = userRepo.findOneByUsername(principal.getName());

		Account profileExists = accountRepo.findByUsername(currentUser.getUsername());

		try {

			if (profileExists == null) {

				accountRepo.save(new Account(editAccount.getFirstName(), editAccount.getLastName(),
						editAccount.getAddress(), editAccount.getContactNo(), editAccount.getEmail(),
						editAccount.getBio(), editAccount.getUsername(), editAccount.getAccDetails()));
			} else {

				profileExists.setFirstName(editAccount.getFirstName());
				profileExists.setLastName(editAccount.getLastName());
				profileExists.setAddress(editAccount.getAddress());
				profileExists.setContactNo(editAccount.getContactNo());
				profileExists.setEmail(editAccount.getEmail());
				profileExists.setBio(editAccount.getBio());
				profileExists.setUsername(editAccount.getUsername());
				profileExists.setAccDetails(editAccount.getAccDetails());

				accountRepo.save(profileExists);
			}

		} catch (Exception e) {
			throw new MySQLDataException("error in editAcccount" + e);
		}
	};

};
