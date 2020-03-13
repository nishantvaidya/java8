package com.test.java8;

import java.util.function.Function;

public class ComparatorExample {
	
	public static void main(String[] args) {
		
		Comparator<Person> cmpAge =  (p1, p2) -> p2.getAge() - p1.getAge();
		Comparator<Person> cmpName =  (p1, p2) -> p2.getName().compareTo(p1.getName());
		
		Function<Person,Integer> f1 = p -> p.getAge();
		Function<Person,String> f2 = p -> p.getName();
		
		Comparator<Person> cmpPerson = Comparator.comparing(Person::getAge);
		Comparator<Person> cmpPersonName = Comparator.comparing(Person::getName);
		
		Comparator<Person> cmp = Comparator.comparing(Person::getAge).thenComparing(Person::getName);
		
		
		
	}

}
