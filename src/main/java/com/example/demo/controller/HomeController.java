package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("user", new User());
		
		return "signup";
	}
	
	@RequestMapping(value="/process_signup", method = RequestMethod.POST)
	public String processSignUp(@ModelAttribute("user") User user,Model model) {
		
		user.setRole("ROLE_ADMIN");
		user.setEnabled(true);
		System.out.println(user);
		
		return "index";
	}
	
	
}
