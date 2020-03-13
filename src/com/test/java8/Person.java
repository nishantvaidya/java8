/**
 * 
 */
package com.test.java8;

import java.util.StringJoiner;


public class Person {

	private String name;
	private  int age;
	
	private String gender;
	
	public Person(){}
	
	public Person(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	
	@Override
	public String toString() {
		return new StringJoiner(                           // In Java 8 and later, StringJoiner is used to construct a sequence of characters separated by a delimiter and optionally starting with a supplied prefix and ending with a supplied suffix.
                " | " ,                                // Delimiter
                 "[ " ,  // Prefix
                " ]"                                   // Suffix
            )
            .add( "name=" + name )                     // Append
            .add( "age=" + age )
            .add( "gender =" + gender )// Append
            .toString(); 
	}
	
	
}
