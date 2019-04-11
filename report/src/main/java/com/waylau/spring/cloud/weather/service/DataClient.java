package com.waylau.spring.cloud.weather.service;

import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("gateway")
public interface DataClient {

    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityName/{cityName}")
    WeatherResponse getWeatherDataByCityName(@PathVariable("cityName") String cityName);

    @GetMapping("/weather/cityId/{cityId}")
    public WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId);

}
