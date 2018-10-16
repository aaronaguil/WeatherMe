package com.core.weather;

import com.core.Day;

public class WeatherInformation {

	private String summary;
	private String weatherStatus;
	private Day day;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getWeatherStatus() {
		return weatherStatus;
	}

	public void setWeatherStatus(String weatherStatus) {
		this.weatherStatus = weatherStatus;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

}
