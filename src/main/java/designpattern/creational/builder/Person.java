package designpattern.creational.builder;

public class Person {
	
	private final String name;
	private final String lastName;
	private final int age;
	private final String address;
	
	private Person(String name, String lastName, int age, String address) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public static class PersonBuilder {
		private String nestedName;
		private String nestedLastName;
		private int nestedAge;
		private String nestedAddress;
		
		public PersonBuilder() {
			super();
		}
		
		public PersonBuilder name(String newName) {
			this.nestedName = newName;
			return this;
		}
		
		public PersonBuilder lastName(String newLastName) {
			this.nestedLastName = newLastName;
			return this;
		}
		
		public PersonBuilder age(int newAge) {
			this.nestedAge = newAge;
			return this;
		}
		
		public PersonBuilder address(String newAddress) {
			this.nestedAddress = newAddress;
			return this;
		}
		
		public Person createPerson() {
			return new Person(nestedName, nestedLastName, nestedAge, nestedAddress);
		}
	}
}


