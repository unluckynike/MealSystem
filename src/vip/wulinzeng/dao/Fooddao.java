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
 * ²Ù×÷food±í
 * 
 * @author 22304
 *
 */
public class Fooddao {

	/**
	 * ²éÑ¯²ËÆ·
	 * 
	 * @param id
	 * @param inputString
	 * @return retList
	 * @throws SQLException
	 */
	public ArrayList<Food> queryFood(int id, String inputString) throws SQLException {
		ArrayList<Food> retList = new ArrayList<Food>();
		String sqlString = "SELECT * FROM food ";
		Connection connection = new DBUtil().getCon();
		if ((id == -1) && (!StringUtil.isEmpty(inputString))) {
			sqlString = sqlString + "WHERE foodname LIKE '%" + inputString + "%'";
		}
		if ((id > 0) && StringUtil.isEmpty(inputString)) {
			sqlString = sqlString + "WHERE id=" + id + "";
		}
		PreparedStatement prepareStatement = connection.prepareStatement(sqlString);
		ResultSet executeQuery = prepareStatement.executeQuery();
		// System.out.println("sql:"+sqlString);
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
		// System.out.println("Fooddao-retList:"+retList);
		return retList;
	}

	public boolean addFood(String foodnameString, String featureString, String materialString, int price, int type,
			String pictureString) throws SQLException {
		boolean flag = false;
		String sqlString = "INSERT INTO food VALUES(NULL,?,?,?,?,?,?,0,-1)";
		Connection addConnection = new DBUtil().getCon();
		PreparedStatement prepareStatement = addConnection.prepareStatement(sqlString);
		prepareStatement.setString(1, foodnameString);
		prepareStatement.setString(2, featureString);
		prepareStatement.setString(3, materialString);
		prepareStatement.setInt(4, price);
		prepareStatement.setInt(5, type);
		prepareStatement.setString(6, pictureString);
		if (prepareStatement.executeUpdate() > 0) {
			flag = true;
		} else {
			System.out.println("Fooddao-addFood:Ìí¼ÓÊ§°Ü");
		}
		prepareStatement.close();
		addConnection.close();
		return flag;
	}

	public boolean deleteFood(int id) throws SQLException {
		boolean flag = false;
		String sqlString = "DELETE FROM food WHERE id=?";
		Connection deleteConnection = new DBUtil().getCon();
		PreparedStatement prepareStatement = deleteConnection.prepareStatement(sqlString);
		prepareStatement.setInt(1, id);
		if (prepareStatement.executeUpdate() > 0) {
			flag = true;
		} else {
			System.out.println("Fooddao-deleteFood:É¾³ýÊ§°Ü");
		}
		prepareStatement.close();
		deleteConnection.close();
		return flag;
	}

	public boolean updateFood(int id, String foodnameString, String featureString, String materialString, int price,
			int type, String pictureString, int hits, String commentString) throws SQLException {
		boolean flag = false;
		Connection updateConnection = new DBUtil().getCon();
		String sqlString = "UPDATE food SET foodname=?,feature=?,material=?,price=?,type=?,picture=?,hits=?,comment=? WHERE id=?";
        PreparedStatement prepareStatement = updateConnection.prepareStatement(sqlString);
		prepareStatement.setString(1, foodnameString);
		prepareStatement.setString(2, featureString);
		prepareStatement.setString(3, materialString);
		prepareStatement.setInt(4, price);
		prepareStatement.setInt(5, type);
		prepareStatement.setString(6, pictureString);
		prepareStatement.setInt(7, hits);
		prepareStatement.setInt(8, FoodUtil.oppositeFoodComment(commentString));
		prepareStatement.setInt(9, id);
		if (prepareStatement.executeUpdate()>0) {
			flag=true;
		}else {
			System.out.println("Fooddao-updateFood:¸üÐÂÊ§°Ü");
		}
		prepareStatement.close();
		updateConnection.close();
		return flag;
	}

}
