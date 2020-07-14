package com;

import java.util.Optional;
import java.util.OptionalInt;

class User{
	
	private String name;
	private String location; // optional
	
	private Optional<String> categroy = Optional.empty(); //optional
	
	private OptionalInt categoryId = OptionalInt.empty();
	
	public User() {
		
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	
	
	public User(String name, String location, Optional<String> categroy) {
		super();
		this.name = name;
		this.location = location;
		this.categroy = categroy;
	}

	public static void process(User user) {
		
		System.out.println("Name: " + user.name.toString());
		if(user.location != null) {
			System.out.println("Location: " + user.location.toString());
		}
		else {
			System.out.println("Location: Not set" );
		}
		
//		if(user.categroy.isPresent()) {
//			System.out.println("Category: " + user.categroy.get().toString());
//		}
//		else {
//			System.out.println("Category: Not set" );
//		}
		
		//System.out.println("Category: " + user.categroy.orElse("Not Set"));
		//user.categroy.ifPresent(v -> System.out.println("Category: " + v));
		user.categroy.ifPresentOrElse(v -> System.out.println("Category: " + v), () -> System.out.println("Category not available"));
		
		
		
	}
	
	
}
public class OptionalDemo {

	public static void main(String[] args) {
		
		User user = new User("Anil", "Mumbai");
		User.process(user);
		
		user = new User("Anil");
		User.process(user);
		
		
		user = new User("Anil", "Mumbai", Optional.of("Category1"));
		User.process(user);
		
		
		System.out.println("OptionalDemo.main()");
		
	}

}




