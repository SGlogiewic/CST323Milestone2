package com.gcu;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.UserAccountServiceInterface;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserAccountServiceInterface accountsService;
	
	@GetMapping("/")
	public String showRegister(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userModel", user);
			return "register";
		}
		
		if (accountsService.registerNewUser(user)) {
			return "index";
		}
		else {
			model.addAttribute("userModel", user);
			return "register";
		}
	}

}
