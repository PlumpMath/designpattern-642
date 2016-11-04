package designpattern.creational.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testCriaPerson() {
		
		String testName = "Pablo";
		String testLastName = "Silva";
		int testAge = 37;
		String testAddress = "Rua Cora Marcolongo dos Reis, 110";
		
		Person person = new Person.PersonBuilder()
				.name(testName)
				.lastName(testLastName)
				.age(testAge)
				.address(testAddress)
				.createPerson();
		
		assertEquals(testName, person.getName());
		assertEquals(testLastName, person.getLastName());
		assertEquals(testAge, person.getAge());
		assertEquals(testAddress, person.getAddress());
	}
}
