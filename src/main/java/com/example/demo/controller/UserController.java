package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Contact;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

@Controller
public class UserController {
	
	private final UserService userService;
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@RequestMapping("/index")
	public String getIndex() {
		System.out.println("im here");
		return "index";
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		User user=new User();
		Contact contact=new Contact();
		contact.setName("sanket");
		List<Contact> conList =new ArrayList<Contact>();
		conList.add(contact);
		user.setUserId(0);
		user.setName("Sanket");
		user.setPassword("Sanket@123");
		user.setEmail("sanket@gmail.com");
		user.setEnabled(true);
		user.setAbout("xyz");
		user.setContacts(conList);
		
		userService.createUser(user);
		
		return "working";
	}
	
}
