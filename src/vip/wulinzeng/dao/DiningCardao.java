package vip.wulinzeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vip.wulinzeng.utils.DBUtil;

/**
 * ²Ù×÷diningcar
 * @author 22304
 *
 */
public class DiningCardao {
	
	/*
	 * SELECT * FROM food LEFT JOIN diningcar ON food.id=diningcar.foodid WHERE userid=3
	 * */
	
     public boolean addDiningCar(int userid,int foodid) throws SQLException {
    	 boolean flag=false;
    	 String sqlString="INSERT INTO diningcar VALUES(null,?,?)";
    	 Connection addConnection=new DBUtil().getCon();
    	 PreparedStatement prepareStatement = addConnection.prepareStatement(sqlString);
    	 prepareStatement.setInt(1, userid);
    	 prepareStatement.setInt(2, foodid);
    	 if (prepareStatement.executeUpdate()>0) {
			flag=true;
		}else {
			System.out.println("DiningCardao-addDiningCar:Ìí¼ÓÊ§°Ü");
		}
    	 prepareStatement.close();
    	 addConnection.close();
    	 return flag;
     }
     
     public boolean deleteDiningCar(int userid,int foodid) throws SQLException {
		boolean flag=false;
		String sqlString="DELETE FROM diningcar WHERE userid=? AND foodid=?";
		Connection deleteConnection=new DBUtil().getCon();
		PreparedStatement prepareStatement = deleteConnection.prepareStatement(sqlString);
		prepareStatement.setInt(1, userid);
		prepareStatement.setInt(2, foodid);
		if (prepareStatement.executeUpdate()>0) {
			flag=true;
		}else {
			System.out.println("DiningCardao-addDiningCar:É¾³ýÊ§°Ü");
		}
		prepareStatement.close();
		deleteConnection.close();
		return flag;
	}

}
