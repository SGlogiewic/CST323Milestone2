package com.gcu.data;

import java.util.List;

import com.gcu.model.UserModel;

public interface UsersDataServiceInterface {

	public UserModel getUserById(int id);
	public List<UserModel> getUsers();
	public List<UserModel> searchUsers(String searchTerm);
	public int addUser(UserModel newUser);
	public boolean deleteUser(int id);
	public UserModel updateUser(UserModel updated);
	public UserModel authenticate(String username, String password);
	public UserModel getUserByUsernme(String username);
}
