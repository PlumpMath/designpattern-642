package designpattern.behavior.iterator;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IteratorTest {
	
	
	private PrintStream old = System.out;
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private PrintStream ps = new PrintStream(baos);
	
	@Before
	public void beforeTests() {
	    System.setOut(ps);
	}
	
	@After
	public void afterTest() {
		System.setOut(old);
	}	
	
	@Test
	public void testIteratorDesignPattern() {
		NameRepository namesRepository = new NameRepository();
		
		for(Iterator names = namesRepository.getIterator(); names.hasNext();) {
			String name = (String) names.next();
			System.out.println("Name: " + name);
		}
		
		String message = "Name: Robert\r\nName: John\r\nName: Julie\r\nName: Lora\r\n";
		assertEquals(message, baos.toString());
	}
	
}
