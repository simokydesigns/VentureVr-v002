package com.vrvideo.web.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vrvideo.data.entity.User;
import com.vrvideo.data.repository.UserRepository;


@Controller
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public String getUsers(Model model) {
		
		//userRepo.save(new User("John", "Kelly", "london", "0645645654", "hello@eircom.net"));
		
		userRepo.findAll().forEach(System.out::println);
		
		//User userData = userRepo.findByUserId(1L);
		List<User> userData = (List<User>) userRepo.findAll();
		
		model.addAttribute("user", userData);
	      
		return "users";
	}

}
