package com.app;

import com.Employee;
import com.Types;


// java Application
public class Application {


	public static void main(String[] args) {
		
		
		System.out.println("Application.main()");
		
		System.out.println("Employee Instances: " + Employee.getCount());
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("ANil");
		employee.setSalary(5000);
		
		System.out.println("Id: " + employee.getId());
		System.out.println("Name: " + employee.getName());
		System.out.println("Salary: " + employee.getSalary());
		
		Employee emp1 = new Employee(2, "Steve", 70000);
		System.out.println("Id: " + emp1.getId());
		System.out.println("Name: " + emp1.getName());
		System.out.println("Salary: " + emp1.getSalary());
		
		Employee emp2 = new Employee(3, "Rahul", 60000);
		System.out.println("Id: " + emp2.getId());
		System.out.println("Name: " + emp2.getName());
		System.out.println("Salary: " + emp2.getSalary());
		
		Employee emp3 = emp2;
		
		Employee emp4 = new Employee(3, "Rahul", 60000);
		
		
		System.out.println("emp1 == emp2: " + (emp1 == emp2)); //false
		System.out.println("emp2 == emp3: " + (emp2 == emp3)); //true
		System.out.println("emp2 == emp4: " + (emp2 == emp4)); //false
		
		System.out.println("emp2.equals(emp4): " + (emp2.equals(emp4))); //true
		
		System.out.println("Employee Instances: " + Employee.getCount());
		
		//Invoke the gc==> NEVER DO THIS
		//employee = emp1 = emp2 = null;
		//System.gc();
	}

}







