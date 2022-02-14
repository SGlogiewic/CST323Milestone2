package com.gcu.business;

import java.util.List;
import com.gcu.model.UserModel;

public interface IUserBusinessService 
{
	public UserModel getById(int Id);
	public List<UserModel> getUsers();
	public List<UserModel> searchUsers(String searchTerm);
	public int addOne(UserModel newUser);
	public boolean deleteOne(long id);
	public UserModel updateOne(long idToUpdate, UserModel updateUser);
	public void init();
	public void destroy();
}
