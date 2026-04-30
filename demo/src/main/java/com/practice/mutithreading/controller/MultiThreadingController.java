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
	public String runTask() throws Exception {
		Future<String> future =  executerService.submit(() -> multiThreadingService.runTask());
		String s1 = future.get();
		System.out.println("Before returns");
		return s1;
//		return "Task submitted successfully";
	}
	
}
