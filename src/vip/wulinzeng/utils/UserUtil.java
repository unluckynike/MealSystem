package vip.wulinzeng.utils;

/**
 * �û�������
 * @author 22304
 *
 */
public class UserUtil {
	public static String userIdent(String ident) {
		switch(ident) {
		   case 1+"":
			   return "����Ա";
		   case 0+"":
			   return "��ͨ�û�";
		   default:
			   return "���δ֪";    
		}
	}
	

}
