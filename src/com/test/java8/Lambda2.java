package com.test.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda2 {
	
	public static void main(String[] args) {
		
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return Integer.compare(s1.length(), s2.length());
			}
			
		};
		List<Integer> list = Arrays.asList(3,5,1,9,9);
		//Collections.sort(list, comp);
		Comparator<Integer> compLambda = Integer::compare;
		Collections.sort(list, compLambda);
		list.forEach(System.out::println);
	}
	
	
   

}
