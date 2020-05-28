package vip.wulinzeng.controller;

import java.sql.SQLException;

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
 * ��ҳ��Ʒ��ѯ
 * 
 * @author 22304
 *
 */
@Controller
public class SystemController {
	/**
	 * ��ҳ��ѯ
	 * 
	 * @param ID
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/QueryFood", method = RequestMethod.POST)
	public ModelAndView queryfoodAndView(@RequestParam(name = "id", required = false) int ID, ModelAndView model)
			throws SQLException {
		//System.out.println(ID + "testid");
		Food queryFood = new QueryFooddao().HomePageQueryfood(ID);
		model.addObject("img", queryFood.getPictureString());
		model.addObject("name", queryFood.getFoodnameString());
		model.addObject("feature", queryFood.getFeatureString());
		model.addObject("material", queryFood.getMaterialString());
		model.addObject("price", queryFood.getPrice());
		model.addObject("type", hoosefoodtype(queryFood.getType()));
		model.addObject("hits", queryFood.getHits());
		model.addObject("comment", queryFood.getComment());
		model.setViewName("HomePagesFoods");
		return model;
	}

	public String hoosefoodtype(int type) {
		switch (type) {
		case 1:
			return "�ҳ�";
		case 2:
			return "����";
		case 3:
			return "��ʳ";
		case 4:
			return "����";
		}
		return "���޷���";
	}
	
	@RequestMapping(value = "/Login")
	public ModelAndView Login(ModelAndView model) {
		model.setViewName("Login");
		return model;
	}
	
	@RequestMapping(value = "/UserLogin",method = RequestMethod.GET)
	public ModelAndView userLogin(
			@RequestParam(name = "username",required = true) String usernameString,
			@RequestParam(name = "password",required = true) String passwordString,
	       ModelAndView model) throws SQLException {
		System.out.println("���ԣ�"+usernameString +"���룺"+passwordString);
		User user=new Userdao().queryUser(usernameString, passwordString);
		System.out.println("dao+:"+user.getIdentString()+user.getAddressString());
		if (user.getIdentString().equals("1")) {
			model.setViewName("AdminIndex");
		}else {
			model.setViewName("UserIndex");
		}
		return model;
	}
	
	@RequestMapping(value = "/Register",method = RequestMethod.GET)
	public ModelAndView Register(ModelAndView model) {
		model.setViewName("Register");
		return model;
	}
	
	@RequestMapping(value = "/UserRegister",method = RequestMethod.POST )
	public ModelAndView userRegister(
			@RequestParam(name = "username",required = true ) String usernameString,
			@RequestParam(name = "password",required = true ) String passwordString,
			@RequestParam(name = "telephone",required = true ) String telephoneString,
			@RequestParam(name = "address",required = true )   String addressString,
			ModelAndView model) {
		
		System.out.println(usernameString+" "+passwordString+" "+telephoneString+" "+addressString+" ");
		model.setViewName("RegisterSuccess");
		return model;
	}
}
