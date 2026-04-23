package com.practice.mutithreading.service;

import org.springframework.stereotype.Service;

@Service
public class MultiThreadingService {
	public void runTask() {
		System.out.println("Started " + Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed " + Thread.currentThread().getName());
	}
	
}
