package com.thangdotaplaptrinhweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.thangdotaplaptrinhweb.dao.IUserDAO;
import com.thangdotaplaptrinhweb.model.UserModel;
import com.thangdotaplaptrinhweb.service.IUserService;

public class UserService implements IUserService {
    @Inject
    private IUserDAO userDAO;

	@Override
	public UserModel findUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		
		return userDAO.findUserNameAndPasswordAndStatus(userName, password, status);
	}

	@Override
	public Long addnewUser(String username, String password, String fullname, Integer status, Long roleid) {
	Long userId = userDAO.addNewUser(username, password, fullname, status, roleid);
		return userId;
	}

	@Override
	public boolean checkUserName(String userName) {
		
		return userDAO.checkUserName(userName);
	}
    
    

}
