package com.controllers;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.core.city.USCity;
import com.core.weather.WeatherReport;
import com.services.CityService;
import com.services.WeatherService;

@Controller
@SessionAttributes({ "currentCity", "currentWeatherReport" })
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	@Autowired
	private CityService cityService;

	@ModelAttribute("currentCity")
	public USCity initCity() {
		USCity currentCity = new USCity();
		return currentCity;
	}

	@ModelAttribute("currentWeatherReport")
	public WeatherReport initWeatherReport() {
		WeatherReport currentWeatherReport = new WeatherReport();
		return currentWeatherReport;
	}

	@RequestMapping("index.do")
	private ModelAndView home() {
		USCity usCity = cityService.getCityInformationByCityAndCounty("Seattle", "King");
		System.out.println("City info: " + usCity);
		ModelAndView mv = new ModelAndView("home.jsp");
		WeatherReport weatherReport = weatherService.getDailyCityWeatherInformation(usCity);
		mv.addObject("weatherReport", weatherReport);
		mv.addObject("currentWeatherReport", weatherReport);
		mv.addObject("city", usCity);
		mv.addObject("currentCity", usCity);

		return mv;
	}

	@RequestMapping("getUSCityWeatherInformationByCity.do")
	private ModelAndView getUSCityWeatherInformationByCity(
			@ModelAttribute("currentWeatherReport") WeatherReport currentWeatherReport,
			@ModelAttribute("currentCity") USCity currentCity, @RequestParam("usCity") String city) {
		List<USCity> usCities = cityService.getCityInformation(city);
		ModelAndView mv = new ModelAndView("home.jsp");
		if (usCities != null && usCities.size() == 1) {
			WeatherReport weatherReport = weatherService.getDailyCityWeatherInformation(usCities.get(0));
			if (weatherReport != null) {
				mv.addObject("weatherReport", weatherReport);
				mv.addObject("city", usCities.get(0));
				mv.addObject("currentCity", usCities.get(0));
				mv.addObject("currentWeatherReport", weatherReport);
			} else {
				mv.addObject("error", "No Weather For That City");
				mv.addObject("city", currentCity);
				mv.addObject("weatherReport", currentWeatherReport);
			}
		} else {
			if (usCities == null) {
				mv.addObject("error", "Please enter another city");
				mv.addObject("city", currentCity);
				mv.addObject("weatherReport", currentWeatherReport);
			} else {
				mv.addObject("error", "Which " + city + " were you talking about");
				mv.addObject("cities", new HashSet<USCity>(usCities));
				mv.addObject("city", currentCity);
				mv.addObject("weatherReport", currentWeatherReport);
			}
		}

		return mv;
	}

	@RequestMapping("getUSCityWeatherInformationByCityAndCounty.do")
	private ModelAndView getUSCityWeatherInformationByCityAndCounty(
			@ModelAttribute("currentWeatherReport") WeatherReport currentWeatherReport,
			@ModelAttribute("currentCity") USCity currentCity, @RequestParam("usCity") String city,
			@RequestParam("county") String county) {
		USCity usCity = cityService.getCityInformationByCityAndCounty(city, county);
		ModelAndView mv = new ModelAndView("home.jsp");
		if (usCity != null) {
			WeatherReport weatherReport = weatherService.getDailyCityWeatherInformation(usCity);
			if (weatherReport != null) {
				mv.addObject("weatherReport", weatherReport);
				mv.addObject("city", usCity);
				mv.addObject("currentCity", usCity);
				mv.addObject("currentWeatherReport", weatherReport);

			} else {
				mv.addObject("error", "No Weather For That City");
				mv.addObject("city", currentCity);
				mv.addObject("currentWeatherReport", currentWeatherReport);
				mv.addObject("weatherReport", currentWeatherReport);

			}
		} else {
			mv.addObject("error", "No Weather For That City");
			mv.addObject("city", currentCity);
			mv.addObject("weatherReport", currentWeatherReport);
		}

		return mv;
	}

}
