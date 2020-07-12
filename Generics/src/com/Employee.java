package com;

import java.util.Objects;


public class Employee implements Comparable<Employee>{

	//class state
	public  static int count;
	
	
	//instance state
	private int id;
	private String name;
	private double salary;
	
	static {
		//System.out.println("Employee.static block()");
		count = 10;
	}
	
	public Employee() {
		
		///System.out.println("Employee.Employee()");
		count++;
	}
	public Employee(int id, String name, double salary) {
		
		this();
		///System.out.println("Employee.Employee() with params");
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	protected void finalize() throws Throwable {
		
		//System.out.println("Employee.finalize()");
	}
	
	public static int getCount() {
		
		return count;
	}

	//properties
	public int getId() {
		
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			
			return this.id == emp.id && this.name.equals(emp.name) && this.salary == emp.salary;
			
		}
		return false;
		
	}
	@Override
	public int hashCode() {
		
		return Objects.hash(this.id, this.name, this.salary);
	}
	@Override
	public int compareTo(Employee emp) {
		
		return this.name.compareTo(emp.name);
	}
	
	
	
}











