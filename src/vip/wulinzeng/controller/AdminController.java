package vip.wulinzeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员
 * @author 22304
 *
 */
@Controller
public class AdminController {

	@RequestMapping(value = "HomePages")
	public ModelAndView welcome(ModelAndView model) {
		model.addObject("author", "海林");
		model.setViewName("HomePages");
		return model;
	}
}
