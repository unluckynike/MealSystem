package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vip.wulinzeng.model.FoodType;
import vip.wulinzeng.utils.DBUtil;
import vip.wulinzeng.utils.StringUtil;

/**
 * ²Ù×÷foodtype±í
 * @author 22304
 *
 */
public class FoodTypedao {

	public ArrayList<FoodType> foodTypeQuery(int id,String inputString) throws SQLException{
		ArrayList<FoodType> retList=new ArrayList<FoodType>();
		String sqlString="SELECT * FROM foodtype ";
		Connection queryConnection=new DBUtil().getCon();
		if ((id==-1)&&(!StringUtil.isEmpty(inputString))) {
			sqlString=sqlString+"WHERE typename LIKE '%"+inputString+"%'";
		}
		if ((id>0)&&(StringUtil.isEmpty(inputString))) {
			sqlString=sqlString+"WHERE id="+id+"";
		}
		PreparedStatement preparedStatement=queryConnection.prepareStatement(sqlString);
		System.out.println(sqlString);
		ResultSet executeQuery = preparedStatement.executeQuery();
		while(executeQuery.next()) {
			FoodType foodType=new FoodType();
		     foodType.setId(executeQuery.getInt("id"));
		     foodType.setTypenameString(executeQuery.getString("typename"));
		     retList.add(foodType);
		}
		preparedStatement.close();
		queryConnection.close();
		//System.out.println("FoodTypeDao-foodTypeQuery"+retList);
		return retList;
	}
	
	
	
	
}
