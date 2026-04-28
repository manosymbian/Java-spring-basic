package com.practice.mutithreading.service;

import org.springframework.stereotype.Service;

@Service
public class MultiThreadingService {
	public String runTask() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Started " + threadName);
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		System.out.println("Completed " + threadName);
		return "Task completed by "+ threadName;
	}
	
}
