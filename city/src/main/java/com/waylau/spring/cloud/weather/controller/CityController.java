package com.waylau.spring.cloud.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.spring.cloud.weather.service.CityDataService;
import com.waylau.spring.cloud.weather.vo.City;

@RestController
public class CityController {

	@Autowired
	private CityDataService cityDataService;
	
	@GetMapping("/citys")
	public List<City> listCity() throws Exception{
		return cityDataService.listCity();
	}
}
