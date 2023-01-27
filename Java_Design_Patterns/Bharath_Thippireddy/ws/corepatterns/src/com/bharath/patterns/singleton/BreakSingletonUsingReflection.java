package com.bharath.patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonUsingReflection {
	public static void main(String[] args) {
		DateUtil dateUtil = DateUtil.getInstance();
		DateUtil dateUtil1 = null;
		
		Constructor[] declaredConstructors = DateUtil.class.getDeclaredConstructors();
		  for (Constructor constructor : declaredConstructors) {
			constructor.setAccessible(true);
			try {
				dateUtil1 = (DateUtil) constructor.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		  System.out.println(dateUtil.hashCode());
		  System.out.println(dateUtil1.hashCode());

	}

}
