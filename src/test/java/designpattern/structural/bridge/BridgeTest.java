package designpattern.structural.bridge;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BridgeTest {

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
	public void testBridge() {
		String message = "Drawing Red Circle: [2 100 99]\r\nDrawing Green Circle: [1 200 30]\r\n"; 
		
		Shape redCircle = new Circle(100, 99, 2, new RedCircle());
		Shape greenCircle = new Circle(200, 30, 1, new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
		
		assertEquals(message, baos.toString());
	}
}
