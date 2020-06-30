package com;

public class Employee {

	//state
	private int id;
	private String name;
	private double salary;
	
	public Employee() {
		System.out.println("Employee.Employee()");
	}
	
	public Employee(int id, String name, double salary) {
		
		System.out.println("Employee.Employee()");
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	protected void finalize() throws Throwable {
		
		System.out.println("Employee.finalize()");
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
	
	
	
	
	
}
