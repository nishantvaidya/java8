package com.test.generic;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Injector {
	
	private Map<Class<?>, Object> objectGraph = new HashMap<>();
	
	public Injector with(Object value){
		objectGraph.put(value.getClass(),value);
		
		return this;
		
	}
	
	public <T> T newInstance(final Class<T> className){
	  return (T)objectGraph.computeIfAbsent(className, this::instantiate);	
	}
	
	private Object instantiate(Class<?> type){
		Constructor<?>[] constructors = null;
		Object obj = null;
		try {
		 constructors = type.getConstructors();
		 obj = constructors[0].newInstance(constructors[0].getParameters());
		if(constructors.length != 1){
			throw new IllegalArgumentException("");
			
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
