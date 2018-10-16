package com.services;

import com.core.city.USCity;
import com.core.weather.WeatherReport;

public interface WeatherService {

	WeatherReport getDailyCityWeatherInformation(USCity usCity);

}
