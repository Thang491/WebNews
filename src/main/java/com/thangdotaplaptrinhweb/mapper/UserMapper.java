package com.thangdotaplaptrinhweb.mapper;

import java.sql.ResultSet;

import com.thangdotaplaptrinhweb.model.RoleModel;
import com.thangdotaplaptrinhweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel user = new UserModel();
		try {
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("userName"));
			user.setFullName(resultSet.getString("fullName"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("roleId"));

			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setCode(resultSet.getString("name"));
	            user.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
         return user;
			
		} catch (Exception e) {
			return null;
			}
		
		
	}

}
