package com.waylau.spring.cloud.weather.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuartzConfiguration2 {

	private final static Logger logger = LoggerFactory.getLogger(QuartzConfiguration2.class);

	//@Scheduled(cron = "0/5 * * * * ?")
	public void doWork() {
		logger.info("this task is running ......");
		/*try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
}
