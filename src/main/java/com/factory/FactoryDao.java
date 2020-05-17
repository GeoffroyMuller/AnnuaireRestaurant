package com.factory;

import com.dao.PlatDao;
import com.dao.RestaurantDao;

public class FactoryDao {
	
	private static FactoryDao instance;
	
	private FactoryDao() { }
	
	public static FactoryDao getInstance() {
		if(instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}
	
	public RestaurantDao getRestaurantDao() {
		return RestaurantDao.getInstance();
	}
	
	public PlatDao getPlatDao() {
		return PlatDao.getInstance();
	}
	
}
