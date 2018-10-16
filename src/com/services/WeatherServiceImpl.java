package com.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.core.city.USCity;
import com.core.weather.WeatherReport;
import com.data.WeatherDAO;
import com.util.WeatherInformationJSONParser;
import com.util.WeatherInformationJSONParserFactory;
import com.util.WeatherInformationType;

public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherDAO weatherDAO;

	private WeatherInformationJSONParser weatherInfoJSONParser;

	@Override
	public WeatherReport getDailyCityWeatherInformation(USCity usCity) {
		String dailyWeatherInformationStr = weatherDAO.getUSCityWeatherInformation(usCity);
		weatherInfoJSONParser = WeatherInformationJSONParserFactory
				.getWeatherInformationJSONParser(WeatherInformationType.DAILY);
		WeatherReport weatherReport =  weatherInfoJSONParser
				.convertToWeatherInformation(dailyWeatherInformationStr);
		
		return weatherReport;
	}

}
