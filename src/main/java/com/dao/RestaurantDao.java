package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DataBase;
import com.factory.FactoryDao;
import com.models.Plat;
import com.models.Restaurant;

public class RestaurantDao {

	private static RestaurantDao instance;

	private RestaurantDao() { }

	public static RestaurantDao getInstance() {
		if(instance == null) {
			instance = new RestaurantDao();
		}
		return instance;
	}

	public void creat(Restaurant resto) throws SQLException {
		String sql = "INSERT INTO restaurant (`id`, `nom`, `adresse`, `specialite`) VALUES (NULL, ?, ?, ?);";
		PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
		pstmt.setString(1, resto.getNom());
		pstmt.setString(2, resto.getAdresse());
		pstmt.setString(3, resto.getSpecialite());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public void update(Restaurant resto) throws SQLException {
		String sql = "UPDATE `restaurant` SET `nom` = ?, `adresse` = ?, `specialite` = ? WHERE `restaurant`.`id` = ?;";
		PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
		pstmt.setString(1, resto.getNom());
		pstmt.setString(2, resto.getAdresse());
		pstmt.setString(3, resto.getSpecialite());
		pstmt.setInt(4, resto.getId());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public void deleteById(int id) throws SQLException {
		String sql = "DELETE FROM `restaurant` WHERE `restaurant`.`id` = ?;";
		PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
	}

	/**
	 * Retourne la liste des restaurant  
	 * @return
	 * @throws SQLException
	 */
	public List<Restaurant> getListeResto() throws SQLException{
		String sql = "SELECT * FROM restaurant";
		List<Restaurant> listeResto = new ArrayList<Restaurant>();
		PreparedStatement pstmt = DataBase.getInstance().prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			List<Plat> listePlat = null;
			try {
				listePlat = new ArrayList<Plat>();
				listePlat = 
						FactoryDao.getInstance().getPlatDao().getListePlatByRestaurant(rs.getInt("id"));
			}catch (SQLException e) {
				e.printStackTrace();
			}
			listeResto.add(new Restaurant(
					rs.getInt("id"),
					rs.getString("nom"),
					rs.getString("adresse"),
					rs.getString("specialite"),
					listePlat));
		}
		return listeResto;
	}

}
