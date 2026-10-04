package com.example.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TrackerApplication {

	static void main(String[] args) {
		SpringApplication.run(TrackerApplication.class, args);
//		for (int strength = 10; strength <= 15; strength++) {
//			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(strength);
//			long start = System.currentTimeMillis();
//			encoder.encode("myPassword123");
//			long time = System.currentTimeMillis() - start;
//			System.out.println("strength " + strength + " -> " + time + " ms");
//		}
	}

}
