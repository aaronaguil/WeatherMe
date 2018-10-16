package com.core.weather;

import java.time.LocalTime;


public class DailyWeatherInformation extends WeatherInformation{

	private double temperatureHigh;
	private double temperatureLow;
	private LocalTime temperatureHighTime;
	private LocalTime temperatureLowTime;
	
	public double getTemperatureHigh() {
		return temperatureHigh;
	}

	public void setTemperatureHigh(double temperatureHigh) {
		this.temperatureHigh = temperatureHigh;
	}

	public double getTemperatureLow() {
		return temperatureLow;
	}

	public void setTemperatureLow(double temperatureLow) {
		this.temperatureLow = temperatureLow;
	}

	public LocalTime getTemperatureHighTime() {
		return temperatureHighTime;
	}

	public void setTemperatureHighTime(LocalTime temperatureHighTime) {
		this.temperatureHighTime = temperatureHighTime;
	}

	public LocalTime getTemperatureLowTime() {
		return temperatureLowTime;
	}

	public void setTemperatureLowTime(LocalTime temperatureLowTime) {
		this.temperatureLowTime = temperatureLowTime;
	}
}
