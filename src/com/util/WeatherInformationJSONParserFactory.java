package com.util;

import java.util.HashMap;
import java.util.Map;

public class WeatherInformationJSONParserFactory {
	
	private static Map<WeatherInformationType, WeatherInformationJSONParser> weatherJSONParserMap;
	
	static {
		weatherJSONParserMap = new HashMap<WeatherInformationType, WeatherInformationJSONParser>();
		weatherJSONParserMap.put(WeatherInformationType.MINUTE, new MinuteWeatherInformationJSONParser());
		weatherJSONParserMap.put(WeatherInformationType.HOURLY, new HourlyWeatherInformationJSONParser());
		weatherJSONParserMap.put(WeatherInformationType.DAILY, new DailyWeatherInformationJSONParser());
		weatherJSONParserMap.put(WeatherInformationType.MONTHLY, new MonthlyWeatherInformationJSONParser());
	}
	
	public static WeatherInformationJSONParser getWeatherInformationJSONParser(WeatherInformationType weatherInformationType) {
		return weatherJSONParserMap.get(weatherInformationType);
	}

}
