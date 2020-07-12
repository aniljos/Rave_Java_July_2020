package com;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//java ReflectionDemo
public class ReflectionDemo {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
//		Employee employee = new Employee(1, "Anil", 70000);
		
//		Class<? extends Employee> clazz = employee.getClass();
		
		Class<Employee> clazz = Employee.class;
		
		System.out.println("Name: " + clazz.getName());
		System.out.println("Package: " + clazz.getPackageName());
		System.out.println("Simple Name: " + clazz.getSimpleName());
		
		
		//Method [] methods =  clazz.getMethods();
		Method [] methods =  clazz.getDeclaredMethods();
		System.out.println("------------Printing Methods------------");
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println("------------End of Methods------------");
		
		
		
		Field [] fields = clazz.getDeclaredFields();
		System.out.println("------------Printing Feilds------------");
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		System.out.println("------------End of Feilds------------");

	}

}
