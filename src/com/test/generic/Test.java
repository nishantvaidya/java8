package com.test.generic;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		
		//Injector inject = new Injector().with("Hello World.!");
		
		//Logger logger = inject.newInstance(Logger.class);
		
		//logger.log();
		
		
	Person p1 = new Person("Neha",38);
	Person p2 = new Person("Nishant",32);
		Person p3 = new Person("Adwi",8);
	Person p4 = new Person("Adwi",6);
	
	List<Person> list = new ArrayList<Person>();
	list.add(p1);
	list.add(p2);
	list.add(p3);
	list.add(p4);
	
	Predicate<Person> pre = p -> p.getAge() > 8;
	
	IntSummaryStatistics summary =list.stream().map(Person::getAge).collect(Collectors.summarizingInt(Integer::valueOf));
	
	
	System.out.println(summary.toString());

	}

}
