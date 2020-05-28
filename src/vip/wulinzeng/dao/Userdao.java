package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vip.wulinzeng.model.User;
import vip.wulinzeng.utils.DBUtil;

/**
 * 操作用户表
 * @author 22304
 *
 */
public class Userdao {

	public User queryUser(String username,String password) throws SQLException {
		User user=null;
		String sqlString="SELECT * FROM user WHERE username=? AND password=?";
		Connection queryConnection=new DBUtil().getCon();
		PreparedStatement preparedStatement=queryConnection.prepareStatement(sqlString);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet result=preparedStatement.executeQuery();
		if (result.next()) {
			user=new User();
			user.setId(result.getInt("id"));
			user.setUsernameString(result.getString("username"));
			user.setPasswordString(result.getString("password"));
			user.setIdentString(result.getString("ident"));
			user.setTelephoneString(result.getString("telephone"));
			user.setAddressString(result.getString("address"));
		}
		else {
			System.out.println("登录失败");
		}
		preparedStatement.close();
		queryConnection.close();
		return user;
	}
	
	/**
	 * 首页用户注册
	 * @param usernameString
	 * @param passwordString
	 * @param telephoneString
	 * @param addressString
	 * @return
	 */
	public boolean addUser(String usernameString,String passwordString,String telephoneString,String addressString) {
		boolean flag=false;
		
		
		
		
		return flag;
	}
	
	
}
