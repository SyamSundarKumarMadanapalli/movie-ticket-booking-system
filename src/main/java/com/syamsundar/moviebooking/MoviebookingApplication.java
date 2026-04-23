package com.syamsundar.moviebooking;

import com.syamsundar.moviebooking.config.BookingProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(BookingProperties.class)
@EnableScheduling
public class MoviebookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviebookingApplication.class, args);
	}

}
