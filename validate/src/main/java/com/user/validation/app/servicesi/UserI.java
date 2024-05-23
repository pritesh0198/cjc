package com.user.validation.app.servicesi;

import java.util.List;

import com.user.validation.app.model.User;

public interface UserI {

	public User saveUser(User u);

	public List<User> showUser();

	public User updateUser(User u, Integer id);

	public User deleteUser(Integer id);

	public User findbyid(Integer id);

}
