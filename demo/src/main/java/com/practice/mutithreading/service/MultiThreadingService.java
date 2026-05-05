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
	
	public CompletableFuture<String> runSecondTask(String input, ExecutorService executorService) {
	    return CompletableFuture.supplyAsync(() -> {
	        String threadName = Thread.currentThread().getName();
	        System.out.println("Second task started " + threadName);

	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }

	        System.out.println("Second task completed " + threadName);
	        return input + " -> processed by second task";
	    }, executorService);
	}
	
	public CompletableFuture<String> runIndependentTask(ExecutorService executorService) {
	    return CompletableFuture.supplyAsync(() -> {
	        String threadName = Thread.currentThread().getName();
	        System.out.println("Independent task started " + threadName);

	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }

	        System.out.println("Independent task completed " + threadName);
	        return "Result from independent task by " + threadName;
	    }, executorService);
	}
	
}
