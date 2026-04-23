package com.practice.mutithreading;

public class Main {
	public static void main(String[] args) {
		Runnable task = () -> {
			System.out.println("Running in " + Thread.currentThread().getName());
		};
		Thread t1 = new Thread(task);
		t1.start();
	}
}
	