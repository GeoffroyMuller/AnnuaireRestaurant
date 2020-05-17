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

			}
			listeResto.add(new Restaurant(
					rs.getInt("id"),
					rs.getString("nom"),
					rs.getString("adresse"),
					rs.getString("specialite"),
					listePlat));
		}
		System.out.println("!!"+listeResto);
		return listeResto;
	}

}
