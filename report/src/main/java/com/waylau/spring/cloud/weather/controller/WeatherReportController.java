package com.waylau.spring.cloud.weather.controller;

import java.util.List;

import com.waylau.spring.cloud.weather.service.DataClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.waylau.spring.cloud.weather.service.CityClient;
import com.waylau.spring.cloud.weather.service.WeatherReportService;
import com.waylau.spring.cloud.weather.vo.City;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

	private static final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

	@Autowired
	private WeatherReportService weatherReportService;

	@Autowired
	private DataClient dataClient;

	@GetMapping("/cityId/{cityId}")
	public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 由城市数据API微服务来提供数据
		List<City> cityList = null;

		try {

			// 由城市数据API微服务提供数据
			cityList = dataClient.listCity();

		} catch (Exception e) {
			logger.error("Exception!", e);
		}

		model.addAttribute("title", "天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getWeatherDataByCityId(cityId));

		return new ModelAndView("weather/report", "reportModel", model);
	}

	@GetMapping("/cityName/{cityName}")
	public ModelAndView getWeatherByCityName(@PathVariable("cityName") String cityName, Model model) throws Exception {
		// 由城市数据API微服务来提供数据
		List<City> cityList = null;

		try {

			// 由城市数据API微服务提供数据
			cityList = dataClient.listCity();

		} catch (Exception e) {
			logger.error("Exception!", e);
		}
		model.addAttribute("title", "天气预报");
		model.addAttribute("cityName", cityName);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getWeatherDataByCityName(cityName));
		return new ModelAndView("weather/report", "reportModel", model);
	}
}
