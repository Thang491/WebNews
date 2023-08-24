package com.thangdotaplaptrinhweb.dao.impl;

import java.util.List;

import com.thangdotaplaptrinhweb.dao.IUserDAO;
import com.thangdotaplaptrinhweb.mapper.UserMapper;
import com.thangdotaplaptrinhweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {


	@Override
	public UserModel findUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
		sql.append("INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ? ");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName ,password, status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long addNewUser(String username, String password,String fullname, Integer status, Long id) {		
		String sql = "INSERT INTO user (username , password, fullname, status, roleid) VALUES (?,?,?,?,?)";
		return insert(sql, username, password, fullname, status ,id);
	}

	@Override
	public boolean checkUserName(String userName) {
		
		String sql = "SELECT * FROM user WHERE username =?";
		
		List<UserModel> user = query(sql, new UserMapper(), userName);
		if(user.isEmpty()) {
			return false;
		}else {
			return true;
		}
		
	}

	
	
}
