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
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserAccountServiceInterface accountsService;
	
	@GetMapping("/")
	public String showLogin(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid UserModel user, BindingResult bindingResult, Model model) {
		boolean success = accountsService.authenticate(user.getUsername(), user.getPassword());
	
		
		if ((bindingResult.getFieldErrorCount("username") > 0 && bindingResult.getFieldErrorCount("password") > 0) || success == false) {
			System.out.println("Login failed for username " + user.getUsername());
			model.addAttribute("userModel", user);
			return "login";
		}
		return "index";
	}
}
