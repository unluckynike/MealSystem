package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vip.wulinzeng.model.User;
import vip.wulinzeng.utils.DBUtil;

/**
 * 操作用户表
 * 
 * @author 22304
 *
 */
public class Userdao {
	/**
	 * 登录功能
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User queryUser(String username, String password) throws SQLException {
		User user = null;
		String sqlString = "SELECT * FROM user WHERE username=? AND password=?";
		Connection queryConnection = new DBUtil().getCon();
		PreparedStatement preparedStatement = queryConnection.prepareStatement(sqlString);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			user = new User();
			user.setId(result.getInt("id"));
			user.setUsernameString(result.getString("username"));
			user.setPasswordString(result.getString("password"));
			user.setIdentString(result.getString("ident"));
			user.setTelephoneString(result.getString("telephone"));
			user.setAddressString(result.getString("address"));
		} else {
			System.out.println("登录失败");
		}
		preparedStatement.close();
		queryConnection.close();
		return user;
	}

	/**
	 * 首页用户注册
	 * 
	 * @param usernameString
	 * @param passwordString
	 * @param telephoneString
	 * @param addressString
	 * @return
	 * @throws SQLException
	 */
	public boolean addUser(String usernameString, String passwordString, String telephoneString, String addressString)
			throws SQLException {
		boolean flag = false;
		String sqlString = "INSERT INTO user VALUES(null,?,?,0,?,?)";
		Connection addConnection = new DBUtil().getCon();
		PreparedStatement preparedStatement = addConnection.prepareStatement(sqlString);
		preparedStatement.setString(1, usernameString);
		preparedStatement.setString(2, passwordString);
		preparedStatement.setString(3, telephoneString);
		preparedStatement.setString(4, addressString);
		if (preparedStatement.executeUpdate()>0) {
			return true;
		}else {
			System.out.println("注册失败");
			return flag;	
		} 
	}

	
}
