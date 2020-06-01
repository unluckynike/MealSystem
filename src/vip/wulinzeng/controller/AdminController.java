package vip.wulinzeng.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vip.wulinzeng.dao.FoodTypedao;
import vip.wulinzeng.dao.Fooddao;
import vip.wulinzeng.dao.Userdao;

/**
 * 管理员
 * @author 22304
 *
 */
@Controller
public class AdminController {
	
	private Userdao userdao=new Userdao();
	private Fooddao fooddao=new Fooddao();
	private FoodTypedao foodtypedao=new FoodTypedao();

	@RequestMapping(value = "/HomePages")
	public ModelAndView welcome(ModelAndView model) {
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
		model.addObject("queryuser", userdao.adminQueryUser(-1,""));
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
		model.addObject("queryuser", userdao.adminQueryUser(-1,searchuserString));
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
		if (userdao.adminDeleteUser(id)) {
			model.setViewName("admin/user_list");	
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
		model.addObject("username", userdao.adminQueryUser(updateID,"").get(0).getUsernameString());
		model.addObject("updateuser", userdao.adminQueryUser(updateID,""));
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
	/**
	 *  查询菜品
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/FoodList")
	public ModelAndView foodList(ModelAndView model) throws SQLException {
		model.addObject("foodlist",fooddao.addminQueryFood(-1, "") );
		model.setViewName("admin/food_list");
		return model;
	}
	
	@RequestMapping(value = "/FoodListQuery",method = RequestMethod.POST)
	public ModelAndView foodListQuery(
			@RequestParam(name = "searchfood",required = true)String searchString,
			ModelAndView model) throws SQLException {
		model.addObject("foodlist", fooddao.addminQueryFood(-1, searchString));
		model.setViewName("admin/food_list");
		return model;
	}
	
	
	
	//分类管理
	/**
	 * 查询菜品分类
	 * @param model
	 * @return model
	 */
	@RequestMapping(value = "/FoodTypeList")
	public ModelAndView foodTypeList(ModelAndView model) {
		try {
			model.addObject("foodtypelist", foodtypedao.foodTypeQuery(-1, ""));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("admin/foodtype_list");
		return model;
	}
	
	@RequestMapping(value = "/FoodTypeListQuery",method = RequestMethod.POST)
	public ModelAndView foodTypeListQuery(
			@RequestParam(name = "searchfoodtype",required = true)String searchString,
			ModelAndView model) throws SQLException {
		model.addObject("foodtypelist", foodtypedao.foodTypeQuery(-1, searchString));
		model.setViewName("admin/foodtype_list");
		return model;
	}
	
	/**
	 * 添加菜品分
	 * @param model
	 * @return model
	 */
	@RequestMapping(value = "/FoodTypeAdd")
	public ModelAndView foodTypeAdd(ModelAndView model) {
        model.setViewName("admin/foodtype_add");
		return model;
	}
	
	@RequestMapping(value = "/FoodTypeAddDo",method = RequestMethod.POST)
	public ModelAndView foodTypeAddDo(
			@RequestParam(name = "newfoodtype",required = true)String addfoodtypeString,ModelAndView model) throws SQLException {
	  if (foodtypedao.foodTypeAdd(addfoodtypeString)) {
		  model.setViewName("admin/foodtype_list");
	} else {
		System.out.println("controller-foodTypeAddDo:添加失败");
	}
		return model;
	}
	
	@RequestMapping(value = "/FoodTypeDelete",method = RequestMethod.POST)
	public ModelAndView foodTypeDelete(
			@RequestParam(name = "id",required = true)int id, ModelAndView model) throws SQLException {
		if (foodtypedao.foodTypeDelete(id)) {
			model.setViewName("admin/foodtype_list");
		}else {
			System.out.println("controller-foodTypeAddDo:删除失败");
		}
		return model;
	}
	
	
	
}
