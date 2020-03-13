package com.test.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiMapExample {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		
		Map<Integer,Map<String,List<Person>>> biMap = new HashMap<>();
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
			
			
			persons.forEach( p -> biMap.computeIfAbsent(p.getAge(), HashMap::new).merge(
					p.getGender(), 
					new ArrayList<>(Arrays.asList(p)), 
					(l1, l2)-> {
						l1.addAll(l2);return l1;
					})
					);
			
			biMap.forEach((k,v)-> System.out.println(k + "--->"+v));
			
			
			
			
			
			
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	}
	

private static Map<Integer,List<Person>> mapByAge(List<Person> list1){
	 
	 return list1.stream().collect(Collectors.groupingBy( Person::getAge));
}


}
