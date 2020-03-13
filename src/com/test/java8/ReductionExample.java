package com.test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReductionExample {

	public static void main(String[] args) {
		
		//Stream.of("two");
		
		//Stream.generate(() -> "one").forEach(System.out::println);;
		
		ThreadLocalRandom.current().ints().forEach(System.out::println);
		
		List<Integer> ints = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		
		List<Integer> ints1 = Arrays.asList(0,1,2,3,4,5);
		List<Integer> ints2 = Arrays.asList(6,7,8,9);
		
		BinaryOperator<Integer> op = (i1,i2) -> (i1+i2)* (i1+i2);
		
		int reduction1 = reduce(ints1,0,op);
		int reduction2 = reduce(ints2,0,op);
		int reduction = reduce(Arrays.asList(reduction1,reduction2),0,op);
		
		//System.out.println("Reduction : "+ reduction);
	}
	
	public static int reduce(
			List<Integer> values,
			int valuIfEmpty, 
			BinaryOperator<Integer> reduction){
		
		int result = valuIfEmpty;
		for(int value : values){
			result = reduction.apply(result, value);
		}
		return result;
		
	}
}
