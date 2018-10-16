package com.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.core.Day;
import com.core.weather.DailyWeatherInformation;
import com.core.weather.WeatherInformation;
import com.core.weather.WeatherReport;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DailyWeatherInformationJSONParser implements WeatherInformationJSONParser{

	@Override
	public WeatherReport convertToWeatherInformation(String jsonStr) {
		WeatherReport weatherReport = new WeatherReport();
		List<WeatherInformation> weatherInformationList = new ArrayList<WeatherInformation>();
		JSONObject obj = new JSONObject(jsonStr);
		JSONObject daily = obj.getJSONObject("daily");
		JSONArray dailyData = daily.getJSONArray("data");
		String weatherReportSummary = daily.getString("summary");
		weatherReport.setSummary(weatherReportSummary);
		for (int i = 0; i<5; i++) {
			JSONObject dailyWeather = (JSONObject) dailyData.get(i);
			ObjectMapper obje = new ObjectMapper();
			String dailySummary = dailyWeather.getString("summary");
			Long dateSec = dailyWeather.getLong("time");
			Long milliDate = dateSec * 1000;
			Date date = new Date(milliDate); 
			LocalDateTime ldtDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
			Day day = new Day();
			day.setMonth(ldtDate.getMonth().toString());
			day.setDayOfMonth(ldtDate.getDayOfMonth());
			day.setDayOfWeek(ldtDate.getDayOfWeek().toString());
			day.setYear(ldtDate.getYear());
			String dailyWeatherStatus = dailyWeather.getString("icon");
			double tempHigh = dailyWeather.getDouble("temperatureHigh");
			double tempLow = dailyWeather.getDouble("temperatureLow");
			Long tempHighTimeSec = dailyWeather.getLong("temperatureHighTime");
			Long tempLowTimeSec = dailyWeather.getLong("temperatureLowTime");
			Long milliHighTime = tempHighTimeSec * 1000;
			Long milliLowTime = tempLowTimeSec * 1000;
			Date tempHighTime = new Date(milliHighTime); 
			Date tempLowTime = new Date(milliLowTime); 
			LocalDateTime ldtHigh = LocalDateTime.ofInstant(tempHighTime.toInstant(), ZoneId.systemDefault());
			LocalTime localTimeHigh = ldtHigh.toLocalTime();
			LocalDateTime ldtLow = LocalDateTime.ofInstant(tempLowTime.toInstant(), ZoneId.systemDefault());
			LocalTime localTimeLow = ldtLow.toLocalTime();
			
			DailyWeatherInformation weatherInfo = new DailyWeatherInformation();
			weatherInfo.setSummary(dailySummary);
			weatherInfo.setTemperatureHigh(tempHigh);
			weatherInfo.setTemperatureLow(tempLow);
			weatherInfo.setTemperatureHighTime(localTimeHigh);
			weatherInfo.setTemperatureLowTime(localTimeLow);
			weatherInfo.setWeatherStatus(dailyWeatherStatus);
			weatherInfo.setDay(day);
			weatherInformationList.add(weatherInfo);
			
		}
		
		weatherReport.setWeatherInformation(weatherInformationList);

		return weatherReport;
	}
	

}
