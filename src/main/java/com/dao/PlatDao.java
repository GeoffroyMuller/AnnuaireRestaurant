package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DataBase;
import com.models.Plat;
import com.models.Restaurant;

public class PlatDao {

	private static PlatDao instance;
	
	private PlatDao() { }
	
	public static PlatDao getInstance() {
		if(instance == null) {
			instance = new PlatDao();
		}
		return instance;
	}
	
	public void creat(Plat plat) throws SQLException {
		String sql = "INSERT INTO `plat` (`id`, `id_restaurant`, `nom`, `prix`, `type`, `description`) VALUES (NULL, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
		pstmt.setInt(1, plat.getId_resto());
		pstmt.setString(2, plat.getNom());
		pstmt.setDouble(3, plat.getPrix());
		pstmt.setString(4, plat.getType());
		pstmt.setString(5, plat.getDescription());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public void update(Plat plat) throws SQLException {
		String sql = "UPDATE `plat` SET `nom` = ?, `prix` = ?, `type` = ?, `description` = ? WHERE `plat`.`id` = ?;";
		PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
		pstmt.setString(1, plat.getNom());
		pstmt.setDouble(2, plat.getPrix());
		pstmt.setString(3, plat.getType());
		pstmt.setString(4, plat.getDescription());
		pstmt.setInt(4, plat.getId());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public void deleteById(int id) throws SQLException {
		String sql = "DELETE FROM `plat` WHERE `plat`.`id` = ?;";
		PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public List<Plat> getListePlatByRestaurant(int id) throws SQLException{
	  	String sql = 
	  			"SELECT * FROM plat WHERE plat.id_restaurant = ?";
	  	List<Plat> listePlat = new ArrayList<Plat>();
        PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        	listePlat.add(new Plat(
        			rs.getInt("id"),
        			rs.getInt("id_restaurant"),
            		rs.getString("nom"),
            		rs.getDouble("prix"),
            		rs.getString("type"),
            		rs.getString("description")
            		));
        }
		return listePlat;
	}
}
