package com.dc.evans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This is the main class that will run this adapter.
 * 
 * @author Jayesh Jain, 
 * Tirnav Solutions, Mumbai
 *
 */

@SpringBootApplication
@EnableScheduling
public class EvansEDIIntegration{
	private static final Logger LOG = LoggerFactory
			.getLogger(EvansEDIIntegration.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("The Evans program.... Starting");
		SpringApplication.run(EvansEDIIntegration.class, args);
		LOG.info("The Evans program.... Start completed");
	}
}
