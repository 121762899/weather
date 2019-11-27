package com.waylau.spring.cloud.weather.service;

/**
 * Weather Data Service.
 * 

 */
public interface WeatherDataService {

	
	void syncWeatherDataByCityId(String cityId);
	
	void syncWeatherDataByCityName(String cityName);
	
}
