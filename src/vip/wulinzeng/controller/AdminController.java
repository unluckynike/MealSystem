package vip.wulinzeng.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vip.wulinzeng.dao.Userdao;
import vip.wulinzeng.model.User;

/**
 * 管理员
 * @author 22304
 *
 */
@Controller
public class AdminController {
	
	private Userdao userdao=new Userdao();

	@RequestMapping(value = "/HomePages")
	public ModelAndView welcome(ModelAndView model) {
		model.addObject("author", "海林");
		model.setViewName("HomePages");
		return model;
	}
	
	/**
	 * 查询用户
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/UserList",method = RequestMethod.GET)
	public ModelAndView userList(ModelAndView model) throws SQLException {		
		ArrayList<User> queryUsers=new ArrayList<User>();
		queryUsers=userdao.adminQueryUser("");
		/*for(int i=0;i<queryUsers.size();i++) {
			User user= (User)queryUsers.get(i);
			System.out.println("test:"+user.getUsernameString());
		}*/
		model.addObject("queryuser", queryUsers);
		model.setViewName("admin/user_list");
		return model;
	}
	/**
	 * 模糊查询
	 * @param searchuserString
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/UserListQuery",method = RequestMethod.POST)
	public ModelAndView userListQuery(
			@RequestParam(name = "searchuser",required = true) String searchuserString,ModelAndView model) throws SQLException {
		ArrayList<User> searchList=new ArrayList<User>();
		//System.out.println("test02:"+searchuserString);
		searchList=userdao.adminQueryUser(searchuserString);
		model.addObject("queryuser", searchList);
		model.setViewName("admin/user_list");
		return model;
	}
	
	/**
	 * 删除用户 bug
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	@RequestMapping(value = "/UserListDelete",method = RequestMethod.POST)
	public ModelAndView deleteUser(
			@RequestParam(name = "id",required = true)int id,HttpServletRequest request,ModelAndView model) throws SQLException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("ID", id);
		System.out.println("test123:"+id);
		if (userdao.adminDeleteUser(id)) {
			model.setViewName("admin/user_list");
			//System.out.println("程序执行了");		
		}else {
			System.out.println("controller-UserListDelete：删除失败");
		}
		return model;
	}
	
	/**
	 * 添加新用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UserListAdd")
	public ModelAndView addUser(ModelAndView model) {
		model.setViewName("admin/user_add");
		return model;
	}
	
	@RequestMapping(value = "UserListAddDo",method = RequestMethod.POST)
	public ModelAndView addUserDo(
			@RequestParam(name = "username",required = true)String usernameString,
			@RequestParam(name = "password",required = true)String passwordString,
			@RequestParam(name = "ident",required = true)String identString,
			@RequestParam(name = "telephone",required =  true)String telephoneString,
			@RequestParam(name = "address",required = true)String addressString,
			ModelAndView model) throws SQLException {
		//System.out.println("controller-UserListAddDo:"+usernameString+" "+passwordString+" "+identString+" "+telephoneString+" "+addressString);
		if (userdao.addUser(usernameString, passwordString, identString, telephoneString, addressString)) {
			model.setViewName("admin/user_list");
		}else {
			System.out.println("controller-UserListAddDo:添加失败");
		}
		return model;
	}
	
	
}
