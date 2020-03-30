package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {//用来连接数据库
	private String dbUrl="jdbc:mysql://localhost:3306/db_mealsystem?useUnicode=true&characterEncoding=utf8"; // 数据库连接地址
	private String dbUserName="root"; // 用户名
	private String dbPassword=""; // 密码
	private String jdbcName="com.mysql.jdbc.Driver"; // 驱动名称
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon(){
		try {
			Class.forName(jdbcName);//找到jar包
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {//数据库未启动 或者 用户名错误 抛出异常
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DBUtil dbUtil=new DBUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
