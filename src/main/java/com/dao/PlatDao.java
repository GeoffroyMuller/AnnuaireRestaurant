package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DataBase;
import com.models.Plat;

public class PlatDao {

	private static PlatDao instance;
	
	private PlatDao() { }
	
	public static PlatDao getInstance() {
		if(instance == null) {
			instance = new PlatDao();
		}
		return instance;
	}
	
	public List<Plat> getListePlatByRestaurant(int id) throws SQLException{
	  	String sql = 
	  			"SELECT * FROM contient JOIN plat ON contient.id_plat = plat.id WHERE contient.id_restaurant = ?";
	  	List<Plat> listePlat = new ArrayList<Plat>();
        PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	listePlat.add(new Plat(
            		rs.getString("nom"),
            		rs.getDouble("prix"),
            		rs.getString("typeDePlat"),
            		rs.getString("description")
            		));
        }
		return listePlat;
	}
}
