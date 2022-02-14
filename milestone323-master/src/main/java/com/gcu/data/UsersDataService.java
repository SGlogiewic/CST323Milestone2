package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.UserMapper;
import com.gcu.model.UserModel;

@Repository
public class UsersDataService implements UsersDataServiceInterface {

	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public UsersDataService(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public UserModel getUserById(int id) {
		UserModel user = null;
		try {
			user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE USER_ID = ?", new UserMapper(), new Object[] {id});
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<UserModel> getUsers() {
		List<UserModel> users = null;
		try {
			users = jdbcTemplate.query("SELECT * FROM users)", new UserMapper());
		} catch (Exception e) {
			System.out.println(e);
		}
		return users;
	}

	@Override
	public int addUser(UserModel newUser) {
		int result = -1;
		try {
			result = jdbcTemplate.update("INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL, PHONE, USERNAME, PASSWORD) VALUES (?,?,?,?,?,?)",
					newUser.getFirstName(),
					newUser.getLastName(),
					newUser.getEmail(),
					newUser.getPhone(),
					newUser.getUsername(),
					newUser.getPassword());
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean result = false;
		try {
			int rows = jdbcTemplate.update("DELETE FROM users WHERE USER_ID = ?", new Object[] {id});
			result = rows > 0;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public UserModel updateUser(UserModel updated) {
		int result = -1;
		try {
			result = jdbcTemplate.update("UPDATE users SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE = ?, USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?)",
					updated.getFirstName(),
					updated.getLastName(),
					updated.getEmail(),
					updated.getPhone(),
					updated.getUsername(),
					updated.getPassword());
		} catch (Exception e) {
			System.out.println(e);
		}
		if (result > 0) {
			return updated;
		}
		return null;
	}

	@Override
	public UserModel authenticate(String username, String password) {
		List<UserModel> users = null;
		try {
			users = jdbcTemplate.query("SELECT * FROM users WHERE USERNAME = ? AND PASSWORD = ?", new UserMapper(), new Object[] {username, password});
		} catch (Exception e) {
			System.out.println(e);
		}
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public UserModel getUserByUsernme(String username) {
		UserModel user = null;
		try {
			user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE USERNAME = ?", new UserMapper(), new Object[] {username});
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<UserModel> searchUsers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

}
