package com.waylau.spring.cloud.weather.service;

import java.util.List;

import com.waylau.spring.cloud.weather.vo.City;

public interface CityDataService {

	List<City> listCity() throws Exception;
}
