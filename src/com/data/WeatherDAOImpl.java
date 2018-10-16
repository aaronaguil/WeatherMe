package com.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.core.city.USCity;



public class WeatherDAOImpl implements WeatherDAO{


	private static final String baseUrlStr = "https://api.darksky.net/forecast/745daf48ac367c6a0fc0a6b03fcb799a/";

	@Override
	public String getUSCityWeatherInformation(USCity usCity) {
		String weatherResponse = null;
		try {
			
			String urlQuery = baseUrlStr + usCity.getLatitude() + "," + usCity.getLongitude() + "";

			URL url = new URL(urlQuery);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			weatherResponse = rd.readLine();
			rd.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return weatherResponse;
	}

	
}
