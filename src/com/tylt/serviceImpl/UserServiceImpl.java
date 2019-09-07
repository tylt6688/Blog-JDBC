package com.tylt.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tylt.bean.User;
import com.tylt.service.UserService;
import com.tylt.servicefactory.ServiceFactory;
import com.tylt.utils.JDBCUtil;

public class UserServiceImpl implements UserService {

	Connection conn = JDBCUtil.getConnection();
	Statement stat = JDBCUtil.getStatement();
	ResultSet resu = null;

	@Override
	public List<User> SelectAll() throws SQLException {
		String sql = "SELECT _id , _username , _password FROM user";
		resu = JDBCUtil.getResult(sql);
		List<User> userlist = new ArrayList<>();
		while (resu.next()) {
			User user = new User();
			user.setId(resu.getInt("_id"));
			user.setUserName(resu.getString("_username"));
			user.setPassWord(resu.getString("_password"));
			userlist.add(user);
		}
		JDBCUtil.getClose();
		return userlist;
	}

	@Override
	public User selectByUserName(String username) throws SQLException {
		String sql = "SELECT * FROM user WHERE _username = '" + username + "'";
		resu = JDBCUtil.getResult(sql);
		User user = new User();
		while (resu.next()) {
			user.setUserName(resu.getString("_username"));
			user.setPassWord(resu.getString("_password"));
			//ulist.add(user);
		}
		return user;
	}

	@Override
	public boolean insert(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into user(_id,_username,_password)" + "values(" + "'" + user.getId() + "','"
				+ user.getUserName() + "','" + user.getPassWord() + "'" + ")";
		resu = JDBCUtil.getResult(sql);
		JDBCUtil.getClose();
		return true;
	}

}
