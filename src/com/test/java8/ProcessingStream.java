package com.test.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingStream {
	
	public static void main(String[] args)  {
		
		List<Person> persons = new ArrayList<>();
		
		try(
				BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(
								ProcessingStream.class.getResourceAsStream("People.txt")));
				Stream<String> lines = reader.lines();
				
			){
			
			lines.map(l-> {
				String[] s = l.split(" ");
				Person p = new Person(s[0].trim(),Integer.parseInt(s[1]),s[2].trim());
				return p;
			})
			//.forEach(persons::add);
			.collect(Collectors.toCollection(()-> persons));
			System.out.println("Persons list size"+ persons.size());
			
			persons.stream().filter(p -> p.getAge() > 1).min(Comparator.comparing(Person::getName,(n1,n2)-> Integer.compare(n2.length(),n1.length())))
			.ifPresent(p ->System.out.println("Name --"+ p.getName()));
			
			//Map<Integer,Person> map = persons.stream().collect(Collectors.toMap(Person::getAge,Function.identity()));
			
			persons.stream().map(Person::getAge).collect(Collectors.collectingAndThen
					(Collectors.groupingBy(Function.identity(),Collectors.counting()), 
									map-> {
										map.values().removeIf( cnt -> cnt < 2 );
										 return( map.keySet() );
									}));
			
			Map<Integer,Set<String>> personsMap = persons.stream().collect(Collectors.groupingBy(
					Person::getAge,
					Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))
					));
			List<String> names = persons.stream().collect(Collectors.mapping(Person::getName, Collectors.toList()));
			System.out.println(names);
			System.out.println(personsMap);
			
			//System.out.println("map"+ map.size());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
