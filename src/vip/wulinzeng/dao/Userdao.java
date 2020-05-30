package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vip.wulinzeng.model.User;
import vip.wulinzeng.utils.DBUtil;
import vip.wulinzeng.utils.StringUtil;
import vip.wulinzeng.utils.UserUtil;

/**
 * 操作user表
 * 
 * @author 22304
 *
 */
public class Userdao {
	/**
	 * 登录功能查询
	 * 
	 * @param username
	 * @param password
	 * @return user
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
			System.out.println("dao登录失败");
		}
		preparedStatement.close();
		queryConnection.close();
		return user;
	}

	/**
	 * 增加用户
	 * 
	 * @param usernameString
	 * @param passwordString
	 * @param telephoneString
	 * @param addressString
	 * @return flag
	 * @throws SQLException
	 */
	public boolean addUser(String usernameString, String passwordString, String identsString,String telephoneString, String addressString)
			throws SQLException {
		boolean flag = false;
		String sqlString = "INSERT INTO user VALUES(null,?,?,?,?,?)";
		Connection addConnection = new DBUtil().getCon();
		PreparedStatement preparedStatement = addConnection.prepareStatement(sqlString);
		preparedStatement.setString(1, usernameString);
		preparedStatement.setString(2, passwordString);
		preparedStatement.setString(3, identsString);
		preparedStatement.setString(4, telephoneString);
		preparedStatement.setString(5, addressString);
		if (preparedStatement.executeUpdate() > 0) {
			flag = true;
		} else {
			System.out.println("Userdao-addUser:注册失败");
		}
		preparedStatement.close();
		addConnection.close();
		return flag;
	}

	/**
	 * 管理员查询用户
	 *  调用方法：
	 *         模糊查询第一个参数传-1 第二个参数传用户名  
	 *         条件查询 第一个参数传id 第二个参数传空串"" 
	 * @param inputString
	 * @return retList
	 * @throws SQLException
	 */
	public ArrayList<User> adminQueryUser(int id,String inputString) throws SQLException {
		ArrayList<User> retList = new ArrayList<User>();
		String sqlString = "SELECT * FROM user ";// PS末尾多一个空格
		if ((id==-1)&&(!StringUtil.isEmpty(inputString))) {// 模糊查询
			sqlString = sqlString + "WHERE username LIKE '%" + inputString + "%'";
		}
		if ((id>0)&&StringUtil.isEmpty(inputString)) {//条件查询
			sqlString = sqlString + "WHERE id="+id+"";
		}
		Connection queryConnection = new DBUtil().getCon();
		PreparedStatement preparedStatement = queryConnection.prepareStatement(sqlString);
		// System.out.println("ssql:"+sqlString);
		ResultSet executeQuery = preparedStatement.executeQuery();
		while (executeQuery.next()) {
			User user = new User();
			user.setId(executeQuery.getInt("id"));
			user.setUsernameString(executeQuery.getString("username"));
			user.setPasswordString(executeQuery.getString("password"));
			user.setIdentString(UserUtil.userIdent(executeQuery.getString("ident")));
			user.setTelephoneString(executeQuery.getString("telephone"));
			user.setAddressString(executeQuery.getString("address"));
			retList.add(user);
		}
		preparedStatement.close();
		queryConnection.close();
		// System.out.println("retlist:"+retList);
		return retList;
	}

	/**
	 * 管理员删除用户 bug
	 * @param id
	 * @return flas
	 * @throws SQLException
	 */
	public boolean adminDeleteUser(int id) throws SQLException {
		boolean flag = false;
		String sqlString = "DELETE FROM user WHERE id=?";
		Connection deleteConnection = new DBUtil().getCon();
		PreparedStatement prepareStatement = deleteConnection.prepareStatement(sqlString);
		prepareStatement.setInt(1, id);
		if (prepareStatement.executeUpdate() > 0) {
			flag=true;
		}else {
			System.out.println("Userdao-adminDeleteUser:删除失败");
		}
		prepareStatement.close();
		deleteConnection.close();
		//System.out.println("sql:"+sqlString);
		return flag;
	}
	
	/**
	 * 修改用戶表
	 * @param id
	 * @param usernameString
	 * @param passwordString
	 * @param identsString
	 * @param telephoneString
	 * @param addressString
	 * @return  flag
	 * @throws SQLException
	 */
	public boolean addminUpdateUser(int id, String usernameString, String passwordString, String identsString,String telephoneString, String addressString) throws SQLException {
		boolean flag=false;
		String sqlString="UPDATE user SET username=?,password=?,ident=?,telephone=?,address=? WHERE id=?";
		Connection updateConnection=new DBUtil().getCon();
		PreparedStatement preparedStatement=updateConnection.prepareStatement(sqlString);
		preparedStatement.setString(1, usernameString);
		preparedStatement.setString(2, passwordString);
		preparedStatement.setString(3, identsString);
		preparedStatement.setString(4, telephoneString);
		preparedStatement.setString(5, addressString);
		preparedStatement.setInt(6, id);
		if (preparedStatement.executeLargeUpdate()>0) {
			flag=true;
		}else {
			System.out.println("Userdao-addminUpdateUser:修改失败");
		}
		return flag;
	}
	
	
}
