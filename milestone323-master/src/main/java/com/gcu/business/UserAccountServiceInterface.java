package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

public interface UserAccountServiceInterface {

	public boolean authenticate(String username, String password);
	public boolean registerNewUser(UserModel user);
	public List<UserModel> getUsers();
	public List<UserModel> searchUsers(String searchTerm);
	public boolean deleteOne(long id);
	public UserModel updateOne(long idToUpdate, UserModel updateUser);
	public void init();
	public void destroy();
}
