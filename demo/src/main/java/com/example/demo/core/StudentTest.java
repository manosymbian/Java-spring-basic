package com.example.demo.core;

import java.util.Arrays;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Mano", "Ajith", "Pinkal");
		Student obj1 = Student.builder().name("Mano").age(10).build();
//		Student obj2 = new Student();
//		System.out.println("Age " + obj1.getName() + obj1.getAge());
//		obj1.setAge(20);
//		System.out.println("Age " + obj1.getName() + obj1.getAge());
//		names.stream().forEach(System.out::println);
		
	}
}
