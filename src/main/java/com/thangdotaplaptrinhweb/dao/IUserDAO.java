package com.thangdotaplaptrinhweb.dao;

import com.thangdotaplaptrinhweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
 
	UserModel findUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	Long addNewUser(String username, String password,String fullname, Integer status, Long id);
	boolean checkUserName(String userName);
 
}
