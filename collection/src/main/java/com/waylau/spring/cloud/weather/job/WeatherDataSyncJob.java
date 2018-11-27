package com.waylau.spring.cloud.weather.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.waylau.spring.cloud.weather.service.CityClient;
import com.waylau.spring.cloud.weather.service.WeatherDataService;
import com.waylau.spring.cloud.weather.vo.City;

/**
 * 天气数据同步
 * @author zhangxuesong
 *
 */
public class WeatherDataSyncJob extends QuartzJobBean {

	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Autowired
	private CityClient cityClient;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			List<City> listCity =cityClient.listCity();
			for(City city : listCity) {
				logger.info("job sync Weather data {}",city.getCityName());
				weatherDataService.syncWeatherDataByCityName(city.getCityName());
			}
		} catch (Exception e) {
			logger.error("sync weather data error");
			e.printStackTrace();
		}
		
	}

}
