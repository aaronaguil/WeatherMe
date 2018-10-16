package com.core.weather;

import java.util.ArrayList;
import java.util.List;

public class HourlyWeatherReport{
	
	List<WeatherInformation> weatherInformation;

	public Object getWeatherInformation() {
		return weatherInformation;
	}
	
	public void addWeatherInformation(WeatherInformation weatherInformation) {
		if(weatherInformation==null) {
			this.weatherInformation = new ArrayList<WeatherInformation>();
		}
		this.weatherInformation.add(weatherInformation);
	}
	
	public void setWeatherInformation(List<WeatherInformation> weatherInformation) {
		this.weatherInformation = weatherInformation;
	}

}
