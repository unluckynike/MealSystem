package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

/**
 * 登录
 * 
 * @author 22304
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();// 得到路径
		request.setCharacterEncoding("UTF-8");
		String emailString = request.getParameter("email");
		String passwordString = request.getParameter("password");
		String sqlString = "SELECT * FROM `user` WHERE email=? AND `password`=?";
		Connection con = new DBUtil().getCon();
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sqlString);
			prepareStatement.setString(1, emailString);
			prepareStatement.setString(2, passwordString);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if (executeQuery.next()) {
				int user_id = executeQuery.getInt("id");
				String user_nameString = executeQuery.getString("name");
				String user_passwordString = executeQuery.getString("password");
				String user_emailString = executeQuery.getString("email");
				// 管理员登录
				if ("admin".equals(user_nameString) && "admin".equals(user_passwordString)
						&& "2230432084@qq.com".equals(user_emailString)) {
					String adminIndexString = contextPath + "/view/system/AdminIndex.jsp";
					response.sendRedirect(adminIndexString);
				} else {
					//普通用户登录
					String indexString = contextPath + "/view/system/UserIndex.jsp";
					response.sendRedirect(indexString);
				}
				System.out.println(
						"登录成功 " + user_id + " " + user_nameString + " " + user_passwordString + " " + user_emailString);

			} else {
				System.out.println("登录失败");
				String loginString = contextPath + "/Login.html";
				response.sendRedirect(loginString);
			}
			executeQuery.close();
			prepareStatement.close();

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
