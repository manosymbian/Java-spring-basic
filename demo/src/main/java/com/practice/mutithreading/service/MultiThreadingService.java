package com.practice.mutithreading.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import org.springframework.stereotype.Service;

@Service
public class MultiThreadingService {
	public CompletableFuture<String> runTaskAsync(ExecutorService executorService) {
		return CompletableFuture.supplyAsync(() -> {
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
		}, executorService);
	}
	
}
