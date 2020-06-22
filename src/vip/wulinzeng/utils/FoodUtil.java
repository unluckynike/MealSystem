package vip.wulinzeng.utils;

public class FoodUtil {
	/**
	 * ��Ʒ�ķ���
	 * 
	 * @param type
	 * @return
	 */
	public static String foodType(int type) {
		switch (type) {
		case 1:
			return "�ҳ�";
		case 2:
			return "����";
		case 3:
			return "��ʳ";
		case 4:
			return "��Ʒ";
		}
		return "���޷���";
	}

	/**
	 * ��Ʒ������
	 * @param comment
	 * @return
	 */
	public static String foodComment(int comment) {
		switch (comment) {
		case 0:
			return "��ʦ�Ƽ�";
		case -1:
			return "������Ʒ";
		default:
			return comment + "";
		}
	}
	
	public static int oppositeFoodComment(String commentString) {
		if (commentString.equals("��ʦ�Ƽ�")) {
			return 0;
		}else if (commentString.equals("������Ʒ")) {
			return 0;
		} else {
			return Integer.parseInt(commentString);
		}
	}
	

}
