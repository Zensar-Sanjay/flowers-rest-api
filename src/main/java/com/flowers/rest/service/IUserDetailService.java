package com.flowers.rest.service;

import java.util.List;

import com.flowers.rest.beans.UserDetail;

public interface IUserDetailService {

	public List<UserDetail> getUserDetails();

	public List<UserDetail> getUniqueUsers();

	public UserDetail updateUserDetailsById(int id, String value);

}
