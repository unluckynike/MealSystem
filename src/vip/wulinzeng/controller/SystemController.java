package vip.wulinzeng.controller;

import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vip.wulinzeng.dao.QueryFooddao;
import vip.wulinzeng.dao.Userdao;
import vip.wulinzeng.model.Food;
import vip.wulinzeng.model.User;

/**
 * 首页菜品查询
 * 
 * @author 22304
 *
 */
@Controller
public class SystemController {
	/**
	 * 首页查询
	 * 
	 * @param ID
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/QueryFood", method = RequestMethod.POST)
	public ModelAndView queryfoodAndView(@RequestParam(name = "id", required = false) int ID, ModelAndView model)
			throws SQLException {
		// System.out.println(ID + "testid");
		Food queryFood = new QueryFooddao().HomePageQueryfood(ID);
		model.addObject("img", queryFood.getPictureString());
		model.addObject("name", queryFood.getFoodnameString());
		model.addObject("feature", queryFood.getFeatureString());
		model.addObject("material", queryFood.getMaterialString());
		model.addObject("price", queryFood.getPrice());
		model.addObject("type", queryFood.getType());
		model.addObject("hits", queryFood.getHits());
		model.addObject("comment", queryFood.getComment());
		model.setViewName("HomePagesFoods");
		return model;
	}

	/**
	 * 登录
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Login")
	public ModelAndView Login(ModelAndView model) {
		model.setViewName("Login");
		return model;
	}

	@RequestMapping(value = "/UserLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam(name = "username", required = true) String usernameString,
			@RequestParam(name = "password", required = true) String passwordString, ModelAndView model,
			HttpServletRequest request) throws SQLException {
		User user = new Userdao().queryUser(usernameString, passwordString);
		HttpSession session = request.getSession();
		session.setAttribute("username", user.getUsernameString());// session: username
		session.setAttribute("userid", user.getId());// session :userid
		model.addObject("username", user.getUsernameString());
		/**
		 * bug 用户名 密码错误 返回404
		 */
		if (user == null) {
			model.setViewName("PasswordOrUserameErro.jsp");
		}
		if (user.getIdentString().equals("1")) {
			model.setViewName("admin/AdminIndex");
		}
		if (user.getIdentString().equals("0")) {
			model.setViewName("user/UserIndex");
		}
		return model;
	}

	/**
	 * 新用户注册
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView Register(ModelAndView model) {
		model.setViewName("Register");
		return model;
	}

	@RequestMapping(value = "/UserRegister", method = RequestMethod.POST)
	public ModelAndView userRegister(@RequestParam(name = "username", required = true) String usernameString,
			@RequestParam(name = "password", required = true) String passwordString,
			@RequestParam(name = "telephone", required = true) String telephoneString,
			@RequestParam(name = "address", required = true) String addressString, ModelAndView model)
			throws SQLException {
		// System.out.println(usernameString+" "+passwordString+" "+telephoneString+"
		// "+addressString+" ");
		String identString = "0";// 用户在登录页面注册均为普通用户
		if (new Userdao().addUser(usernameString, passwordString, identString, telephoneString, addressString)) {
			model.setViewName("RegisterSuccess");
		} else {
			model.setViewName("RegisterFaild");
		}
		return model;
	}

	//退出系統
	@RequestMapping(value = "/Exit")
	public ModelAndView exit(ModelAndView model,HttpServletRequest request) {
		 Enumeration<String> em = request.getSession().getAttributeNames();
		      while(em.hasMoreElements()){
		        request.getSession().removeAttribute(em.nextElement().toString());
		model.setViewName("HomePages");
	     }
		  	return model;
   }
}
