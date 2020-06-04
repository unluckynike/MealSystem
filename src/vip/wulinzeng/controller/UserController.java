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

@Controller
public class UserController {

	private Fooddao fooddao;
	private DiningCardao diningCardao;

	public UserController() {
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
			model.setViewName("user/user_order");//�����
		}else {
			System.out.println("controller-userOrderCar:���ʧ��");
		}
		return model;
	}

	@RequestMapping(value = "/UserCancleOrder",method = RequestMethod.POST)
	public ModelAndView userCancleOrder(
			@RequestParam(name = "id",required = true)int foodID,
			ModelAndView model,HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int userID=(int)request.getSession().getAttribute("userid");
		if (diningCardao.deleteDiningCar(userID, foodID)) {
			model.setViewName("user/user_order");//�����
		}else {
			System.out.println("controller-userOrderCar:ɾ��ʧ��");
		}
		return model;
	}
	
}
