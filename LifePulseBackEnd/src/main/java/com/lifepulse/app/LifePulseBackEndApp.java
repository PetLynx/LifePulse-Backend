package com.lifepulse.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controller"})
public class LifePulseBackEndApp {

	public static void main(String[] args) {
		SpringApplication.run(LifePulseBackEndApp.class, args);
	}

}
