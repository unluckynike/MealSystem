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
			return "����";
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

}
