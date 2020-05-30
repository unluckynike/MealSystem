package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vip.wulinzeng.model.Food;
import vip.wulinzeng.utils.DBUtil;
import vip.wulinzeng.utils.FoodUtil;

/**
 * ��ҳ��ʾ�Ĳ�Ʒ �����������ҳ��
 * @author 22304
 *
 */
public class QueryFooddao {

	public Food HomePageQueryfood(int id) throws SQLException {
		Food foodRst=null;
		String sqlString="SELECT * from food WHERE id=?";
		Connection queryConnection=new DBUtil().getCon();
		PreparedStatement preparedStatement=queryConnection.prepareStatement(sqlString);
		preparedStatement.setInt(1, id);
		ResultSet executeResultSet=preparedStatement.executeQuery();
		if (executeResultSet.next()) {
			foodRst=new Food();
			foodRst.setId(executeResultSet.getInt("id"));
			foodRst.setFoodnameString(executeResultSet.getString("foodname"));
			foodRst.setFeatureString(executeResultSet.getString("feature"));
			foodRst.setMaterialString(executeResultSet.getString("material"));
			foodRst.setPrice(executeResultSet.getInt("price"));
			foodRst.setType(FoodUtil.foodType(executeResultSet.getInt("type")));
			foodRst.setPictureString(executeResultSet.getString("picture"));
			foodRst.setHits(executeResultSet.getInt("hits"));
			foodRst.setComment(FoodUtil.foodComment(executeResultSet.getInt("comment")));
		}
		else {
			System.out.println("��ѯ�޽��");
		}
		preparedStatement.close();
		queryConnection.close();
		return foodRst;
	}
}
