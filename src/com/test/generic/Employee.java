package com.test.generic;

public class Employee extends Person {
    
	private String dept;
	
	Employee(String name, int age, String dept) {
		super(name,age);
		this.dept = dept;
	}

	public String getDept(){
		return this.dept;
	}

}
