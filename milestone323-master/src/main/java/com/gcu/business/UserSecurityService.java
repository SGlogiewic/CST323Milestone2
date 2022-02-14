package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.model.UserModel;

@Service
public class UserSecurityService implements UserDetailsService {
	
	@Autowired
	UsersDataService usersDAO;
	
	public UserSecurityService(UsersDataService dataService) {
		usersDAO = dataService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Looking for: " + username);
		UserModel user = usersDAO.getUserByUsernme(username);
		
		if (user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else {
			System.out.println("User not found.");
			throw new UsernameNotFoundException("Username " + username + " was not found");
		}
	}

}
