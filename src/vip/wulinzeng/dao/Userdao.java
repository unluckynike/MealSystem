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
 * �����û���
 * 
 * @author 22304
 *
 */
public class Userdao {
	/**
	 * ��¼���ܲ�ѯ
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
			System.out.println("��¼ʧ��");
		}
		preparedStatement.close();
		queryConnection.close();
		return user;
	}

	/**
	 * ��ҳ�û�ע��
	 * 
	 * @param usernameString
	 * @param passwordString
	 * @param telephoneString
	 * @param addressString
	 * @return flag
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
		if (preparedStatement.executeUpdate() > 0) {
			return true;
		}
		preparedStatement.close();
		addConnection.close();
		System.out.println("ע��ʧ��");
		return flag;
	}

	/**
	 * ����Ա��ѯ�����û�
	 * 
	 * @param inputString
	 * @return retList
	 * @throws SQLException
	 */
	public ArrayList<User> adminQueryUser(String inputString) throws SQLException {
		ArrayList<User> retList = new ArrayList<User>();
		String sqlString = "SELECT * FROM user ";// PSĩβ��һ���ո�
		if (!StringUtil.isEmpty(inputString)) {// ģ����ѯ
			sqlString=sqlString+"WHERE username LIKE '%" + inputString + "%'";
		}
		Connection queryConnection = new DBUtil().getCon();
		PreparedStatement preparedStatement = queryConnection.prepareStatement(sqlString);
		//System.out.println("ssql:"+sqlString);
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
		//System.out.println("retlist:"+retList);
		return retList;
	}

}
