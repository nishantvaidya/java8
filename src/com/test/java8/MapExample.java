package com.test.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExample {
	public static void main(String[] args) {
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
			}).forEach(persons::add);
			
			List<Person> list1 = persons.subList(1,10);
			List<Person> list2 = persons.subList(10,persons.size());
			
			Map<Integer,List<Person>> map1 = mapByAge(list1);
			//map1.forEach((k,v) -> System.out.println(k +"-->"+ v));
			Map<Integer,List<Person>> map2 = mapByAge(list2);
			
			
			map2.entrySet().stream().forEach(e -> 
						map1.merge(e.getKey(),
								e.getValue(),
								(l1, l2) ->{ 
									l1.addAll(l2); 
									return l1;
								}));
			map1.forEach((k,v) -> System.out.println(k +"-->"+ v));
			
			
								
			System.out.println("Persons list size"+ persons.size());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

 }
	


private static Map<Integer,List<Person>> mapByAge(List<Person> list1){
	 
	 return list1.stream().collect(Collectors.groupingBy( Person::getAge));
}
}


