package com.test.java8;

public class PredicateImplExamples {
	
	public static void main(String[] args) {
		Predicate<String> p1 = s -> s.length() < 20;
		Predicate<String> p2 = s -> s.length() > 5 ;
		
		Predicate<String> p3 = p1.and(p2);
		
		Predicate<Integer> p4 = Predicate.isEquals(1);
		
		System.out.println("Hello word---" + p3.test("Hello World"));
	}
	
	

}
