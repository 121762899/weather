package com.waylau.spring.cloud.weather.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * WeatherDataService 实现.
 * 

 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	
	private static Logger log = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	private static final long TIME_OUT = 1800l;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public void syncWeatherDataByCityId(String cityId) {
		String uri = WEATHER_URI + "citykey=" + cityId;
		saveWeatherData(uri);
	}

	@Override
	public void syncWeatherDataByCityName(String cityName) {
		String uri = WEATHER_URI + "city=" + cityName;
		saveWeatherData(uri);
	}
	
	private void saveWeatherData(String uri) {
		String strBody ="";
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
	
			ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
			if (respString.getStatusCodeValue() == 200) {
				strBody = respString.getBody();
				ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
			}else {
				log.error("获取天气数据失败");
			}
	}

}
