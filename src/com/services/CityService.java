package com.services;

import java.util.List;

import com.core.city.USCity;

public interface CityService {

	List<USCity> getCityInformation(String city);

	USCity getCityInformationByCityAndCounty(String city, String county);
	
	

}
