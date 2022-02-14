package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataServiceInterface;
import com.gcu.model.UserModel;

@Service
public class UserAccountService implements UserAccountServiceInterface {
	
	@Autowired
	UsersDataServiceInterface usersDAO;

	@Override
	public boolean authenticate(String username, String password) {
		return usersDAO.authenticate(username, password) != null;
	}

	@Override
	public boolean registerNewUser(UserModel user) {
		if (usersDAO.getUserByUsernme(user.getUsername()) == null) {
			return usersDAO.addUser(user) > 0;
		}
		return false;
	}

	@Override
	public void init() {
		System.out.println("Creating UserAccountService Bean");
	}

	@Override
	public void destroy() {
		System.out.println("Destroying UserAccountService Bean");

	}

	@Override
	public List<UserModel> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> searchUsers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserModel updateOne(long idToUpdate, UserModel updateUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
