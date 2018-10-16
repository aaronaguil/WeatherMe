package com.data;

import java.util.List;

import com.core.city.USCity;

public interface CityDAO{

	List<USCity> getUSCityInformation(String city);

	USCity getUSCityInformationByCityAndCounty(String city, String county);

}
