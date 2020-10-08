package com.dev.med.siboback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@ComponentScan({
		"com.dev.med.siboback.controllers",
		"com.dev.med.siboback.services",
		"com.dev.med.siboback.data"
})
@SpringBootApplication
@EnableAutoConfiguration
@CrossOrigin()
public class SibobackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SibobackApplication.class, args);
	}

}
