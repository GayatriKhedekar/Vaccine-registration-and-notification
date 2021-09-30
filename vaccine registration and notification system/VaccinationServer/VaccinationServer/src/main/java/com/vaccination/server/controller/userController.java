package com.vaccination.server.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vaccination.server.repo.userRepo;
import com.vaccination.server.DAO.login;
import com.vaccination.server.models.UserModel;




@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class userController {
	
	
	
	@Autowired
	userRepo userRepo;
	
	@PostMapping("/api/user/add")
	public String registerUser(@RequestBody UserModel user)
	{
		userRepo.save(user);
		 return "Data Saved";
	}
	
	
	
	@GetMapping("/api/add/login/{username}/{password}")
	public List<UserModel> login(@PathVariable String username, @PathVariable String password)
	{
		return userRepo.findAllgmail(username,password);
		
		
	}
	
	
	
	
	@GetMapping("/api/user/login/{username}/{password}")
	public String loginUser(@PathVariable String username, @PathVariable String password)
	{
		
	  login login = new login();
	  
	  return login.user(username, password);
	  
	}
	
	
	@GetMapping("/auth/user/get/{id}")
	public Optional<UserModel> user(@PathVariable long id)
	{
		return userRepo.findById(id);
	}
	
	@GetMapping("/api/user/getall")
	public List<UserModel> getAllUsers()
	{
		return userRepo.findAll();
		
	}
	
	
	@GetMapping("/api/get/only/{type}")
	public List<UserModel> getHospital(@PathVariable String type)
	{
		return userRepo.findAllBytype(type);
	}
	
	
	@PutMapping("/api/user/update")
	public UserModel update(@RequestBody UserModel user)
	{
		return userRepo.save(user);
	}
	
	
	@GetMapping("/api/user/delete/{id}")
	public String deleteUser(@PathVariable long id)
	{
		userRepo.deleteById(id);
		
		return "deleted";
	}
	
	@GetMapping("/api/user/getbycity/{city}")
	public List<UserModel> getbycity(@PathVariable String city)
	{
		return userRepo.findAllBycity(city);
		
		
	}
	
	
	
	
	

}
