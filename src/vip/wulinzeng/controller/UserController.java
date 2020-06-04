package vip.wulinzeng.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vip.wulinzeng.dao.DiningCardao;
import vip.wulinzeng.dao.Fooddao;
import vip.wulinzeng.dao.Userdao;

@Controller
public class UserController {

	private Fooddao fooddao;
	private DiningCardao diningCardao;
	private Userdao userdao;

	public UserController() {
		this.userdao=new Userdao();
		this.diningCardao = new DiningCardao();
		this.fooddao = new Fooddao();
	}

	@RequestMapping(value = "/UserOrder")
	public ModelAndView userOrder(ModelAndView model) throws SQLException {
		model.addObject("foodlist", fooddao.queryFood(-1, ""));
		model.setViewName("user/user_order");
		return model;
	}

	@RequestMapping(value = "/UserQueryFood", method = RequestMethod.POST)
	public ModelAndView usertQueryFood(@RequestParam(name = "searchfood", required = true) String searchString,
			ModelAndView model) throws SQLException {
		model.addObject("foodlist", fooddao.queryFood(-1, searchString));
		model.setViewName("user/user_order");
		return model;
	}

	@RequestMapping(value = "/UserOrderCar",method = RequestMethod.POST)		
	public ModelAndView userOrderCar(
			@RequestParam(name = "id",required = true)int foodID,
			ModelAndView model,HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		int userID=(int)request.getSession().getAttribute("userid");
		if (diningCardao.addDiningCar(userID, foodID)) {
			model.setViewName("user/user_order");//需调优
		}else {
			System.out.println("controller-userOrderCar:添加失败");
		}
		return model;
	}

	@RequestMapping(value = "/UserCancleOrder",method = RequestMethod.POST)
	public ModelAndView userCancleOrder(
			@RequestParam(name = "id",required = true)int foodID,
			ModelAndView model,HttpServletRequest request) throws SQLException {
		int userID=(int)request.getSession().getAttribute("userid");
		if (diningCardao.deleteDiningCar(userID, foodID)) {
			model.setViewName("user/user_order");//需调优
		}else {
			System.out.println("controller-userOrderCar:删除失败");
		}
		return model;
	}
	
	@RequestMapping(value = "/UserInfor")
	public ModelAndView userInfor(ModelAndView model,HttpServletRequest request) throws SQLException {
		int userID=(int)request.getSession().getAttribute("userid");
		model.addObject("updateuser", userdao.QueryUser(userID, ""));
		model.setViewName("user/user_infor");
		return model;
	}
	
	@RequestMapping(value = "/UserUpdateInfor",method = RequestMethod.POST)
	public ModelAndView userUpdateInfor(
			@RequestParam(name = "username",required = true)String usernameString,
			@RequestParam(name = "password",required = true)String passwordString,
			@RequestParam(name = "telephone",required = true)String telephoneString,
			@RequestParam(name = "address",required = true)String addressString,
			ModelAndView model,HttpServletRequest request) throws SQLException {
		int userID=(int)request.getSession().getAttribute("userid");
		if (userdao.UpdateUser(userID, usernameString, passwordString, "0", telephoneString, addressString)) {
			model.setViewName("user/user_infor");//需调优
		}
		return model;
	}
	
}
