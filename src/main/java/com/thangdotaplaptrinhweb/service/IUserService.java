package com.thangdotaplaptrinhweb.service;

import com.thangdotaplaptrinhweb.model.UserModel;

public interface IUserService {
	UserModel findUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	Long addnewUser(String username, String password,String fullname, Integer status, Long roleid);
	boolean checkUserName(String userName);

}
