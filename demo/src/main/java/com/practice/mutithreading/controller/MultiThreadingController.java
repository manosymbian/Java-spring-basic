package com.practice.mutithreading.controller;

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
	
	@GetMapping("/run")
	public String runTask() {
		new Thread(() -> multiThreadingService.runTask()).start();
		return "Task triggered";
	}
	
}
