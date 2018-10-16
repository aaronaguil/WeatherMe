package com.core.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherReport {
	
	private String summary;
	private List<WeatherInformation> weatherInformation;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

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
