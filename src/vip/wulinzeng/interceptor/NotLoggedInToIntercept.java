package vip.wulinzeng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import vip.wulinzeng.utils.StringUtil;

public class NotLoggedInToIntercept implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		// TODO Auto-generated method stub
         String usernameString=(String) request.getSession().getAttribute("username");
		if (StringUtil.isEmpty(usernameString)) {
			response.sendRedirect(request.getContextPath()+"Login");
			System.out.println("À¹½ØÆ÷£º"+request.getContextPath());
			return false;
		}
		return true;
	}

}
