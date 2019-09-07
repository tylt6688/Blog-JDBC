package com.tylt.service;

import java.sql.SQLException;
import java.util.List;

import com.tylt.bean.User;

public interface UserService {
	public List<User> SelectAll() throws SQLException;
	public User selectByUserName(String username) throws SQLException;
	public boolean insert(User user) throws SQLException;
}
