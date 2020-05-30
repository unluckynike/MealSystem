package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vip.wulinzeng.model.Food;
import vip.wulinzeng.utils.DBUtil;
import vip.wulinzeng.utils.FoodUtil;
import vip.wulinzeng.utils.StringUtil;

/**
 * 操作food表
 * 
 * @author 22304
 *
 */
public class Fooddao {

	/**
	 * 查询菜品
	 * @param id
	 * @param inputString
	 * @return retList
	 * @throws SQLException
	 */
	public ArrayList<Food> addminQueryFood(int id, String inputString) throws SQLException {
		ArrayList<Food> retList = new ArrayList<Food>();
		String sqlString = "SELECT * FROM food ";
		Connection connection = new DBUtil().getCon();
		if ((id == -1) && (!StringUtil.isEmpty(inputString))) {
			sqlString = sqlString + "WHERE foodname LIKE '%" + inputString + "%'";
		}
		if ((id > 0) && StringUtil.isEmpty(sqlString)) {
			sqlString = sqlString + "WHERE id=" + id + "";
		}
		PreparedStatement prepareStatement = connection.prepareStatement(sqlString);
		ResultSet executeQuery = prepareStatement.executeQuery();
		while(executeQuery.next()) {
			Food food=new Food();
			food.setId(executeQuery.getInt("id"));
			food.setFoodnameString(executeQuery.getString("foodname"));
			food.setFeatureString(executeQuery.getString("feature"));
			food.setMaterialString(executeQuery.getString("material"));
			food.setPrice(executeQuery.getInt("price"));
			food.setType(FoodUtil.foodType(executeQuery.getInt("type")));
			food.setPictureString(executeQuery.getString("picture"));
		    food.setHits(executeQuery.getInt("hits"));
		    food.setComment(FoodUtil.foodComment(executeQuery.getInt("comment")));
		    retList.add(food);
		}
		prepareStatement.close();
		connection.close();
		//System.out.println("Fooddao-retList:"+retList);
		return retList;
	}
	

}
