package com.waylau.spring.cloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waylau.spring.cloud.weather.vo.Weather;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private DataClient dataClient;

	@Override
	public Weather getWeatherDataByCityId(String cityId) {
		WeatherResponse resp = dataClient.getWeatherDataByCityId(cityId);
		return resp.getData();
	}

	@Override
	public Weather getWeatherDataByCityName(String cityName) {
		WeatherResponse resp = dataClient.getWeatherDataByCityName(cityName);
		return resp.getData();
	}

}
