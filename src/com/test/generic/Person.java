package com.test.generic;

import java.util.Comparator;
import java.util.StringJoiner;

public class Person implements Comparable<Person> {
	
	private String name;
	
	private int age;
	
	Person(){
		
	}
	
	Person(String name, int age){
		 this.name = name;
		 this.age = age;
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return new StringJoiner(                           // In Java 8 and later, StringJoiner is used to construct a sequence of characters separated by a delimiter and optionally starting with a supplied prefix and ending with a supplied suffix.
                " | " ,                                // Delimiter
                 "[ " ,  // Prefix
                " ]"                                   // Suffix
            )
            .add( "name=" + name )                     //e Append
            .add( "age=" + age )
            .toString(); 
	}

	@Override
	public int compareTo(Person o) {
		  return Comparator.comparing(Person::getName)
	              .thenComparingInt(Person::getAge)
	              .compare(this, o);
	}
	 
	 

}
