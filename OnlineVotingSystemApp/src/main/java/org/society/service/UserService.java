package org.society.service;

import java.util.List;

import org.society.entities.User;

public interface UserService {
	public int registerUser(User user);
	public int updateUser(User user);
	public int deleteUser(int userId);
	public List<User> viewUserList();
	public User findByUserId(int userId);
}
