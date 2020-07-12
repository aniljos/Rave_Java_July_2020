package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionsDemo {

	public static void main(String[] args) {
		
		//collectionsSet();
		//collectionListString();
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "ANil", 90000));
		employees.add(new Employee(2, "Steve", 80000));
		employees.add(new Employee(3, "Amol", 110000));
		employees.add(new Employee(4, "Mahesh", 70000));
		
		for (Employee employee : employees) {
			System.out.println("Id: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Slary: " + employee.getSalary());

		}
		
		employees.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				
				//equal ==> 0
				// greater than ==> +ve
				//less ==> -ve
				return (int) Math.round(o1.getSalary() - o2.getSalary());
			}
		});
		
		System.out.println("After sorting...");
		for (Employee employee : employees) {
			System.out.println("Id: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Slary: " + employee.getSalary());

		}
		
		
		employees.sort(new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				
				return o1.compareTo(o2);
			}
		});
		
		System.out.println("After sorting...");
		for (Employee employee : employees) {
			System.out.println("Id: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Slary: " + employee.getSalary());

		}
		
		Collections.sort(employees);
		
		
	}

	private static void collectionListString() {
		List<String> names = new ArrayList<String>();
		names.add("Virat");
		names.add("Sachin");
		names.add("Dhoni");
		names.add("Rohit");
		names.add("Sachin");
		
		for (String name : names) {
			System.out.println(name);
		}
		
		names.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				
				return s1.compareTo(s2);
			}
		});
		System.out.println("After sort....");
		for (String name : names) {
			System.out.println(name);
		}
	}

	private static void collectionsSet() {
		//Raw types(recommened not to be used)
		/*
		 * Set set = new HashSet(); set.add(100); set.add(200); set.add("300");
		 * 
		 * for (Object object : set) { System.out.println(object); }
		 * 
		 * for (Iterator iterator = set.iterator(); iterator.hasNext();) { Integer i =
		 * (Integer) iterator.next(); System.out.println(i);
		 * 
		 * }
		 */
		
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(100);
		numbers.add(200);
		numbers.add(300);
		numbers.add(200);
		numbers.add(400);
		numbers.add(500);
		numbers.add(600);
		
		
		for (Integer i : numbers) {
			System.out.println(i);
		}
		
//		for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
//			System.out.println(integer);
//		}
	}

}
;
