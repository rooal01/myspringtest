package com.example.mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.domain.User;
import com.example.mvc.domain.UserRepository;

@Controller 
public class UserManagementController {
	@Autowired
	UserRepository UserRepo;
	
	@RequestMapping(value="rest/users", method=RequestMethod.GET)
	@ResponseBody
	public  List<User> getusers(){
		
		return UserRepo.findAll();
	}
	
	@RequestMapping(value="users", method=RequestMethod.GET)
	public  String webgetusers(Model model){
		List<User> AllUsers = UserRepo.findAll();
		model.addAttribute("users", AllUsers);
		return "AllUsers";
	}
	
	@RequestMapping(value="rest/user/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public  void deleteuser(@PathVariable Long id){
		
		UserRepo.deleteById(id);
		
	}
	
	@RequestMapping(value="rest/deleteusers", method=RequestMethod.POST)
	@ResponseBody
	public  void deleteuser(@RequestBody List<User> users){
		
		UserRepo.deleteInBatch(users);
		
	}
	
	@RequestMapping(value="rest/user/{UserId}", method=RequestMethod.GET)
	@ResponseBody
	public Optional<User> getuser(@PathVariable Long UserId){
		
		return UserRepo.findById(UserId);
		
	}
	
	//Only adding consumes and produces for Swagger documentation
	@RequestMapping(value="/rest/createUser", method=RequestMethod.POST, consumes = {
	        "application/JSON",
	        "application/XML"
	    }, produces = {"application/JSON",
		        "application/XML"})
	@ResponseBody
	public User createuser(@RequestBody User user){
		
		
//		User user = new User();
//		user.setPassword(password);
//		user.setUsername(username);
		
		return UserRepo.save(user);
		
	}
	
	@RequestMapping(value="rest/createUsers", method=RequestMethod.POST, consumes = {
	        "application/JSON",
	        "application/XML"
	    }, produces = {"application/JSON",
		        "application/XML"} )
	@ResponseBody
	public List<User> createuser(@RequestBody List<User> user){
		
		
//		User user = new User();
//		user.setPassword(password);
//		user.setUsername(username);
		
		return UserRepo.saveAll(user);
		
	}

}
