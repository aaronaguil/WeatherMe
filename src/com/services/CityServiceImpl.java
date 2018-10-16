package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.core.city.USCity;
import com.data.CityDAO;

public class CityServiceImpl implements CityService{
	@Autowired
	private CityDAO cityDAO;
	
	@Override
	public List<USCity> getCityInformation(String usCityIn) {
		List<USCity> usCities = cityDAO.getUSCityInformation(usCityIn);
		return usCities;
	}

	@Override
	public USCity getCityInformationByCityAndCounty(String city, String county) {
		USCity usCity = cityDAO.getUSCityInformationByCityAndCounty(city, county);

		return usCity;
	}
}
