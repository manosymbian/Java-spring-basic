package com.practice.mutithreading.configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiThreadingConfiguration {
	@Bean
	public ExecutorService executerService() {
		return Executors.newFixedThreadPool(5);
	}

}
