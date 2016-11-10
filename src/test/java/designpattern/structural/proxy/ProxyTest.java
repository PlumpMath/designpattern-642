package designpattern.structural.proxy;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProxyTest {
	
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
	public void testProxyDesignPattern() {
		
		Image image = new ProxyImage("test_200gb.jpg");
		image.display();
		System.out.println("");
		
		image.display();
		
		String message = "Loading: test_200gb.jpg\r\n" +
							"Displaying: test_200gb.jpg\r\n" +
							"\r\n" +
							"Displaying: test_200gb.jpg\r\n";
		assertEquals(message, baos.toString());
	}
	
	
}
