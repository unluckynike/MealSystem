package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vip.wulinzeng.model.Food;
import vip.wulinzeng.utils.DBUtil;
import vip.wulinzeng.utils.FoodUtil;

/**
 * ²Ù×÷diningcar
 * 
 * @author 22304
 *
 */
public class DiningCardao {

	public boolean addDiningCar(int userid, int foodid) throws SQLException {
		boolean flag = false;
		String sqlString = "INSERT INTO diningcar VALUES(null,?,?)";
		Connection addConnection = new DBUtil().getCon();
		PreparedStatement prepareStatement = addConnection.prepareStatement(sqlString);
		prepareStatement.setInt(1, userid);
		prepareStatement.setInt(2, foodid);
		if (prepareStatement.executeUpdate() > 0) {
			flag = true;
		} else {
			System.out.println("DiningCardao-addDiningCar:Ìí¼ÓÊ§°Ü");
		}
		prepareStatement.close();
		addConnection.close();
		return flag;
	}

	public boolean deleteDiningCar(int userid, int foodid) throws SQLException {
		boolean flag = false;
		String sqlString = "DELETE FROM diningcar WHERE userid=? AND foodid=?";
		Connection deleteConnection = new DBUtil().getCon();
		PreparedStatement prepareStatement = deleteConnection.prepareStatement(sqlString);
		prepareStatement.setInt(1, userid);
		prepareStatement.setInt(2, foodid);
		if (prepareStatement.executeUpdate() > 0) {
			flag = true;
		} else {
			System.out.println("DiningCardao-addDiningCar:É¾³ýÊ§°Ü");
		}
		prepareStatement.close();
		deleteConnection.close();
		return flag;
	}

	/*
	 * SELECT * FROM food LEFT JOIN diningcar ON food.id=diningcar.foodid WHERE
	 * userid=3
	 */
	public ArrayList<Food> checkOrderCar(int userId) throws SQLException {
		ArrayList<Food> retList = new ArrayList<Food>();
		String sqlString = "SELECT * FROM food LEFT JOIN diningcar ON food.id=diningcar.foodid WHERE userid=?";
		Connection connection = new DBUtil().getCon();
		PreparedStatement prepareStatement = connection.prepareStatement(sqlString);
		prepareStatement.setInt(1, userId);
		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			Food food = new Food();
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
		//System.out.println("retList:"+retList);
		return retList;
	}

}
