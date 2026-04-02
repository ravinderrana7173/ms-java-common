package com.common.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class ApplicationStartup.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class ApplicationStartup {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStartup.class, args);
	}

}
