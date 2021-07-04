package com.roze.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.roze.domain.User;
//import com.roze.repository.UserRepository;
import com.roze.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	//@Autowired
	//private UserRepository userRepository;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute @Valid User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "register";
		}

		else {
			userService.save(user);
			return "redirect:/";
		}

	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
