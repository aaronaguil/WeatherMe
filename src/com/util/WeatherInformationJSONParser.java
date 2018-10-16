package com.util;

import com.core.weather.WeatherReport;

public interface WeatherInformationJSONParser {

	public WeatherReport convertToWeatherInformation(String jsonStr);
}
