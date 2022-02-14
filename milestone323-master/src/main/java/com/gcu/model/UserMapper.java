package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserModel> {

	/*
	 * users table
	 * 
	 * Class Fields    | Table Fields
	 * --------------------------------------------------
	 * id				USER_ID
	 * firstName		FIRST_NAME
	 * lastName			LAST_NAME
	 * email			EMAIL
	 * phone			PHONE
	 * username			USERNAME
	 * password			PASSWORD
	 * 
	 */
	
	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel user = new UserModel(
				rs.getInt("USER_ID"),
				rs.getString("FIRST_NAME"),
				rs.getString("LAST_NAME"),
				rs.getString("EMAIL"),
				rs.getString("PHONE"),
				rs.getString("USERNAME"),
				rs.getString("PASSWORD")
				);
		return user;
	}
}
