package com.practice.mutithreading;

public class ExampleMultiThreading extends Thread {
	@Override
	public void run() {
		System.out.println("Thread running "+Thread.currentThread().getName());
		// TODO Auto-generated method stub
//		super.run();
	}
}
