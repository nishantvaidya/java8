package com.test.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Person >   {
	
	private List<T> list ; 
	
	 CustomList( ){
		 
		 list = new ArrayList<>();
	 }
	 
	 
	 public T get(int index){
		return list.get(index);
		 
	 }
	 
	 public  CustomList<T> add(T t){
		
		 
		 list.add(t);
		 return this;
		 
		 
		 
	 }
	 
	 public String toString(){
		 return list.toString();
	 }


	
	public void sort() {
		// TODO Auto-generated method stub
		 Collections.sort(list);
		 
	}


	

}
