package com.test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicatesExamples {
	public static void main(String[] args) {
		Predicate<String> p1 = s -> s.length()<20;
		Predicate<String> p2 = s -> s.length()>3;
		Predicate<String> p3 = p1.and(p2);
		
		List<String> strings = Arrays.asList("one","two","three","four","five");
		
		List<String> results = new ArrayList<>();
		String str = "";
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = s-> str.concat(s);
		
		Predicate<String> p4 = Predicate.isEqual("two");
		Predicate<String> p5 = Predicate.isEqual("three");
		strings.forEach(c1.andThen(c2));
		//System.out.println("Final Output"+ str);
		
		Stream<String> stringStream = strings.stream();
		
		//stringStream.peek(System.out::println).forEach(results::add);
		
		List<Integer> list1 = Arrays.asList(1,4,5,6,7);
		List<Integer> list2 = Arrays.asList(2,8,10);
		List<Integer> list3 = Arrays.asList(3,9);
		list1.stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);;
		Function<List<Integer>, Stream<?>> func = l -> l.stream();
		
		//list.stream().flatMap(func).forEach(System.out::println);
}

}
