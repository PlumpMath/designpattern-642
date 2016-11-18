package designpattern.behavior.visitor;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VisitorDesignPattern {
	
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
	public void testVisitorPattern() {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
		
		String message = "Displaying Mouse.\r\n" +
							"Displaying Keyboard.\r\n" +
							"Displaying Monitor.\r\n" +
							"Displaying Computer.\r\n";
		
		assertEquals(message, baos.toString());
	}
	
}
