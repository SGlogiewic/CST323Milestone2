package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.UserAccountServiceInterface;
import com.gcu.data.UsersDataServiceInterface;
import com.gcu.model.SearchUserModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/manage")
public class ManagementController 
{
	@Autowired
	UserAccountServiceInterface accountsService;
	
	@GetMapping("/")
	 public String showAll(Model model)
    {
        List<UserModel> users = accountsService.getUsers();
        model.addAttribute("title", "Show all users");
        model.addAttribute("searchModel", new SearchUserModel());
        model.addAttribute("user", users);
        return "user";
    }
	
	@GetMapping("/searchForm")
	public String displaySearchForm(Model model)
	{
		// Display Login Form View
		model.addAttribute("title", "Search Users");
		model.addAttribute("searchUserModel", new SearchUserModel());
		return "userSearchForm";
	}
	
	@PostMapping("/searchResults")
	public String showAllUsers(@Valid SearchUserModel searchModel, BindingResult bindingResult, Model model)
	{
		System.out.println("Performing search results for " + searchModel.getSearchTerm());
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search for Users");
			return "searchUserForm";
		}
		List<UserModel> users = UserSearch.searchUserModel(searchModel.getSearchTerm());
		model.addAttribute("title", "Search for Orders");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("user", users);
		return "user";
	}
}
