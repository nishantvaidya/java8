package com.test.java8;


@FunctionalInterface
public interface Predicate<T> {
	
	public boolean test(T t);
	
	public default Predicate<T> and(Predicate<T> p){
		return  t -> test(t) && p.test(t);
	}
	
	public static <U> Predicate<U> isEquals(U s){
		return t -> t.equals(s);
	}

}
