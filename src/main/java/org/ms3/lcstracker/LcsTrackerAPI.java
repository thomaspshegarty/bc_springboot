package org.ms3.lcstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LcsTrackerAPI {
	
	public static void main(String[] args) {
		SpringApplication.run(LcsTrackerAPI.class, args);
	}
	
}
