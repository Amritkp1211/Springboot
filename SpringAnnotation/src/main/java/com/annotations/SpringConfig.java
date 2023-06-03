package com.annotations;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class SpringConfig {
   
	
	
	    @Async
	    @Scheduled(fixedRate = 1000)
	    public void scheduleFixedRateTaskAsync() throws InterruptedException {
	        System.out.println(
	          "Fixed rate task async - " + System.currentTimeMillis() / 1000);
	        Thread.sleep(2000);
	    

	}
}
