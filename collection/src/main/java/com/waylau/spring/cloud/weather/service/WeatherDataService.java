package com.waylau.spring.cloud.weather.service;

/**
 * Weather Data Service.
 * 
 * @since 1.0.0 2017年11月22日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface WeatherDataService {

	
	void syncWeatherDataByCityId(String cityId);
	
	void syncWeatherDataByCityName(String cityName);
	
}
