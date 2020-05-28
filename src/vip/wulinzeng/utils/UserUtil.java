package vip.wulinzeng.utils;

/**
 * 用户工具类
 * @author 22304
 *
 */
public class UserUtil {
	public static String userIdent(String ident) {
		switch(ident) {
		   case 1+"":
			   return "管理员";
		   case 0+"":
			   return "普通用户";
		   default:
			   return "身份未知";    
		}
	}

}
