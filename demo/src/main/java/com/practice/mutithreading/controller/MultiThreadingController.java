package com.practice.mutithreading.controller;
import java.util.stream.Collectors;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

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
	public CompletableFuture<String> runTask() throws Exception {
		return multiThreadingService.runTaskAsync(executerService)
				.thenApply(result -> result + " [processed by controller]");
		
//		Future<String> future =  executerService.submit(() -> multiThreadingService.runTask());
//		String s1 = future.get();
//		System.out.println("Before returns");
//		return s1;
		
//		return "Task submitted successfully";
	}
	@GetMapping("/sequence")
	public CompletableFuture<String> runCompose() {
		return multiThreadingService.runTaskAsync(executerService)
				.thenCompose(result -> 
					multiThreadingService.runSecondTask(result, executerService)
				)
				.thenApply(finalResult -> finalResult + " [final]");
	}
	
	
	@GetMapping("/parallel")
	public CompletableFuture<String> runParallel() {
		CompletableFuture<String> future1 = multiThreadingService.runTaskAsync(executerService);
		CompletableFuture<String> future2 = multiThreadingService.runIndependentTask(executerService);
		return future1.thenCombine(future2, (r1, r2) -> {
			return r1 + " | " + r2 + " combined";
		});
	}
	
	@GetMapping("/all")
	public CompletableFuture<String> runAllTasks() {

//	    CompletableFuture<String> f1 =
//	            multiThreadingService.runTaskAsync(executerService); // 10s
//
//	    CompletableFuture<String> f2 =
//	            multiThreadingService.runIndependentTask(executerService); // 5s
//
//	    CompletableFuture<String> f3 =
//	            multiThreadingService.runThirdTask(executerService); // 3s
//
//	    return CompletableFuture.allOf(f1, f2, f3)
//	    		.thenApply(v -> {
//	    			String r1 = f1.join();
//	    			String r2 = f2.join();
//	    			String r3 = f3.join();
//	    			return r1 + " | " + r2 + " | " + r3 + " [all combined]";
//	    		});
		
		 		
		List<CompletableFuture<String>> futures = List.of(
			multiThreadingService.runTaskAsync(executerService),
			multiThreadingService.runIndependentTask(executerService),
			multiThreadingService.runThirdTask(executerService)
		);
		return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
				.thenApply(v -> 
					futures.stream()
						.map(CompletableFuture::join)
						.collect(Collectors.joining(" | ")) + " all combined"
				);
	}
}
