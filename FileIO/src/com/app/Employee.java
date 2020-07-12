package com.app;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Objects;

public class Employee implements Comparable<Employee>, Externalizable {

	// class state
	public static int count;

	// instance state
	private int id;
	private String name;
	private double salary;
	private transient String password;
	private Address address = new Address();

	static {
		// System.out.println("Employee.static block()");
		count = 10;
	}

	public Employee() {

		/// System.out.println("Employee.Employee()");
		count++;
	}

	public Employee(int id, String name, double salary) {

		this();
		/// System.out.println("Employee.Employee() with params");
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(int id, String name, double salary, String password, Address address) {
		
		this();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.password = password;
		this.address = address;
	}

	@Override
	protected void finalize() throws Throwable {

		// System.out.println("Employee.finalize()");
	}

	public static int getCount() {

		return count;
	}

	// properties
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

	public void print() {

		System.out.println(String.format("Id: %d, Name: %s, Salary: %.2f, Pwd: %s", id, name, salary, password));
		System.out.println(String.format("City: %s, State: %s", address.getCity(), address.getState()));
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		//Serialization
		System.out.println("Employee.writeExternal()");
		out.writeInt(id);
		out.writeUTF(name);
		out.writeDouble(salary);
		out.writeUTF(address.getCity());
		out.writeUTF(address.getState());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		//Deserialization
		System.out.println("Employee.readExternal()");
		id = in.readInt();
		name = in.readUTF();
		salary = in.readDouble();
		address = new Address();
		address.setCity(in.readUTF());
		address.setState(in.readUTF());
	
	}
	
}












