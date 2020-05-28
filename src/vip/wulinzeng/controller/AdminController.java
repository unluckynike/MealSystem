package vip.wulinzeng.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	public ModelAndView userListQuery(ModelAndView model) {
		
		return model;
	}
}
