package designpattern.structural.decorator;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DecoratorTest {
	
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
	public void testDecoradorPattern() {
		Shape circle = new Circle();
		Shape redCircle = new RedShapeDecorator(new Circle());
		
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
	    System.out.println("Circle with normal border");
	    circle.draw();
	    
	    System.out.println("\nCircle of red border");
	    redCircle.draw();

	    System.out.println("\nRectangle of red border");
	    redRectangle.draw();
	    
	    String message = "Circle with normal border\r\n" +
							"Shape: Circle\r\n" +
							"\n" +
							"Circle of red border\r\n" +
							"Shape: Circle\r\n" +
							"Border Color: Red\r\n" +
							"\n" +
							"Rectangle of red border\r\n" +
							"Shape: Rectangle\r\n" +
							"Border Color: Red\r\n";
	    
	    assertEquals(message, baos.toString());
	}
}
