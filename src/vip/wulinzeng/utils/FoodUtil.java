package vip.wulinzeng.utils;

public class FoodUtil {
	/**
	 * 菜品的分类
	 * 
	 * @param type
	 * @return
	 */
	public static String foodType(int type) {
		switch (type) {
		case 1:
			return "家常";
		case 2:
			return "凉菜";
		case 3:
			return "主食";
		case 4:
			return "川菜";
		}
		return "暂无分类";
	}

	/**
	 * 菜品的评价
	 * @param comment
	 * @return
	 */
	public static String foodComment(int comment) {
		switch (comment) {
		case 0:
			return "厨师推荐";
		case -1:
			return "正常菜品";
		default:
			return comment + "";
		}

	}

}
