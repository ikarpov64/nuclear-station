package org.javaacademy;

import org.javaacademy.station.NuclearStation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NuclearStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuclearStationApplication.class, args);
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(NuclearStationApplication.class, args);
//		NuclearStation bean = applicationContext.getBean(NuclearStation.class);
//		bean.start(3);
	}

}
