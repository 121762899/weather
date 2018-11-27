package com.waylau.spring.cloud.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.waylau.spring.cloud.weather.vo.WeatherResponse;

@FeignClient("msa-weather-data-eureka")
public interface WeatherDataClient {

	@GetMapping("/weather/cityId/{cityId}")
	public WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId);
	
	@GetMapping("/weather/cityName/{cityName}")
	public WeatherResponse getWeatherDataByCityName(@PathVariable("cityName") String cityName);
	
}
