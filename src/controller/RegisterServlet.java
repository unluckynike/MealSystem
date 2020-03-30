package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String contextPath = request.getContextPath();// 得到路径
		request.setCharacterEncoding("UTF-8");
		String nameString = request.getParameter("name");
		String emailString = request.getParameter("email");
		String passwordString = request.getParameter("password");
		String sqlString = "INSERT INTO `user` VALUES(NULL,?,?,?)";
		Connection con = new DBUtil().getCon();// 用con操作数据库
		try {
			PreparedStatement statement = con.prepareStatement(sqlString);
			statement.setString(1, nameString);
			statement.setString(2, passwordString);
			statement.setString(3, emailString);
			if(statement.executeUpdate()>0) {
				System.out.println("注册成功");
				String loginString=contextPath+"/Login.html";
				response.sendRedirect(loginString);
			}else {
				System.out.println("注册失败");
			}
			
			/*Statement state=con.createStatement();/
			int count = statement.executeUpdate(sqlString);
			if (count > 0) {
				System.out.println("注册成功");
			} else {
				System.out.println("注册失败");
			}*/
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


			}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
