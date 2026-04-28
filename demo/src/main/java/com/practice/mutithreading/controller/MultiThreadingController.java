package com.practice.mutithreading.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.mutithreading.service.MultiThreadingService;

@RestController
@RequestMapping("/task")
public class MultiThreadingController {
	@Autowired
	private MultiThreadingService multiThreadingService;
	
	@Autowired
	private ExecutorService executerService;
	
	@GetMapping("/run")
	public String runTask() {
		Future<String> future = executerService.submit(() -> {
			return multiThreadingService.runTask();
		});
		return "Task submitted successfully";
	}
	
}
