package com.waylau.spring.cloud.weather.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Configuration.
 * 
 * @since 1.0.0 2017年11月22日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Configuration
public class RestConfiguration {
	
	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = builder.build();
		//reInitMessageConverter(restTemplate);
		return restTemplate;
	}
	
	
	 /*初始化RestTemplate，RestTemplate会默认添加HttpMessageConverter
     * 添加的StringHttpMessageConverter非UTF-8
     * 所以先要移除原有的StringHttpMessageConverter，
     * 再添加一个字符集为UTF-8的StringHttpMessageConvert
     * */
     @SuppressWarnings("unused")
	private void reInitMessageConverter(RestTemplate restTemplate){
         List<HttpMessageConverter<?>> converterList=restTemplate.getMessageConverters();
         HttpMessageConverter<?> converterTarget = null;
         for (HttpMessageConverter<?> item : converterList) {
             if (item.getClass() == StringHttpMessageConverter.class) {
                 converterTarget = item;
                 break;
             }
         }

         if (converterTarget != null) {
             converterList.remove(converterTarget);
         }
         HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
         converterList.add(converter);
     }
}
