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

import vip.wulinzeng.dao.Fooddao;
import vip.wulinzeng.dao.Userdao;
import vip.wulinzeng.model.Food;
import vip.wulinzeng.model.User;

/**
 * 管理员
 * @author 22304
 *
 */
@Controller
public class AdminController {
	
	private Userdao userdao=new Userdao();
	private Fooddao fooddao=new Fooddao();

	@RequestMapping(value = "/HomePages")
	public ModelAndView welcome(ModelAndView model) {
		model.addObject("author", "海林");
		model.setViewName("HomePages");
		return model;
	}
	
	//回管理员首页
	@RequestMapping(value = "/BackAdminIndex")
	public ModelAndView backAdminIndex(ModelAndView model) {
		model.setViewName("admin/AdminIndex");
		return model;
	}
	//管理用户
	/**
	 * 查询用户
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/UserList",method = RequestMethod.GET)
	public ModelAndView userList(ModelAndView model) throws SQLException {		
		ArrayList<User> queryUsers=new ArrayList<User>();
		queryUsers=userdao.adminQueryUser(-1,"");
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
		searchList=userdao.adminQueryUser(-1,searchuserString);
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
		//System.out.println("test123:"+id);
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
	
	/**
	 * 修改用户信息
	 * @param model
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/UserListUpdate")
	public ModelAndView updateUser(
			@RequestParam(name = "id",required = true)int updateID,ModelAndView model) throws SQLException {
		ArrayList<User> updateList=new ArrayList<User>();
		updateList=userdao.adminQueryUser(updateID,"");
		model.addObject("username", updateList.get(0).getUsernameString());
		model.addObject("updateuser", updateList);
		model.setViewName("admin/user_update");
		return model;
	}
	
	@RequestMapping(value = "/UserListUpdateDo",method = RequestMethod.POST)
	public ModelAndView updateUserDo(
			@RequestParam(name = "id",required = true)int id,
			@RequestParam(name = "username",required = true)String usernameString,
			@RequestParam(name = "password",required = true)String passwordString,
			@RequestParam(name = "ident",required = true)String identString,
			@RequestParam(name = "telephone",required =  true)String telephoneString,
			@RequestParam(name = "address",required = true)String addressString,
			ModelAndView model) throws SQLException {
		//System.out.println("controller-UserListUpdateDo:"+id+" "+usernameString+" "+passwordString+" "+identString+" "+telephoneString+" "+addressString);
		if(userdao.addminUpdateUser(id, usernameString, passwordString, identString, telephoneString, addressString)) {
			model.setViewName("admin/user_list");
		}else {
			System.out.println("controller-UserListUpdateDo:修改失败");
		}
		return model;
	}
	
	//菜品管理
	@RequestMapping(value = "/FoodList")
	public ModelAndView foodList(ModelAndView model) throws SQLException {
		ArrayList<Food> foodList=new ArrayList<Food>();
		foodList=fooddao.addminQueryFood(-1, "");
		model.addObject("foodlist",foodList );
		model.setViewName("admin/food_list");
		return model;
	}
	
	@RequestMapping(value = "/FoodListQuery",method = RequestMethod.POST)
	public ModelAndView foodListQuery(
			@RequestParam(name = "searchfood",required = true)String searchString,
			ModelAndView model) throws SQLException {
		ArrayList<Food> searcList=new ArrayList<Food>();
		searcList=fooddao.addminQueryFood(-1, searchString);
		model.addObject("foodlist", searcList);
		model.setViewName("admin/food_list");
		return model;
	}
	
}
