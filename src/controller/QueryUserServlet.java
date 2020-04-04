package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		//System.out.println("sdasd");testpath
		String contextPath = request.getContextPath();// µÃµ½Â·¾¶
		request.setCharacterEncoding("UTF-8");
		String sqlString="SELECT * FROM `user`";
		Connection connection=new DBUtil().getCon();
        List<Map> list=new ArrayList<Map>();
        try {
			PreparedStatement prepareStatement = connection.prepareStatement(sqlString);
		    ResultSet executeQuery = prepareStatement.executeQuery();
		    while(executeQuery.next()) {
		    	//int user_id = executeQuery.getInt("id");
				String user_nameString = executeQuery.getString("name");
				String user_passwordString = executeQuery.getString("password");
				String user_emailString = executeQuery.getString("email");
		    	
				Map map=new HashMap();
				//map.put("id", user_id);
				map.put("name", user_nameString);
				map.put("password", user_passwordString);
				map.put("email", user_emailString);
				System.out.println(map);
				list.add(map);
				/*
				 * for(Map map_1:list) { System.out.println(map_1); }
				 */
		    }
		    executeQuery.close();
		    prepareStatement.close();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("key_list", list);
        System.out.println(contextPath);
        String adminIndexString=contextPath+"/view/system/UserIndex.jsp";
        request.getRequestDispatcher(adminIndexString).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
