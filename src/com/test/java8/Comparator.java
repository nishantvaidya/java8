package com.test.java8;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
	
	 public  int compare(T t1, T t2);
	 
	 public static <U> Comparator<U> comparing(Function<U,Comparable> f){
		 return (p1,p2)-> f.apply(p1).compareTo(f.apply(p2));
	 }
	 
	 
	 
	 public default  Comparator<T> thenComparing(Comparator<T> comp){
		 return (p1,p2)-> compare(p1, p2) == 0 ? comp.compare(p1, p2) : compare(p1, p2);
	 }
	 
	 public default  Comparator<T> thenComparing(Function<T,Comparable> f){
		 Comparator<T> cmp = comparing(f);
		 return thenComparing(cmp);
	 }

}
