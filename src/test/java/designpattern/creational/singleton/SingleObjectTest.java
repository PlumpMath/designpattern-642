package designpattern.creational.singleton;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class SingleObjectTest {

	
	@Test
	public void testSingletonPattern() {
		
		String message = "Doing something....Hello world!";
		
		SingleObject singleObject1 = SingleObject.getInstance();
		SingleObject singleObject2 = SingleObject.getInstance();
		
		assertEquals(singleObject1, singleObject2);
		
		PrintStream old = System.out;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);

	    System.setOut(ps);
	    singleObject1.showMessage();
	    assertEquals(message, baos.toString().replace("\r\n", ""));
	    System.setOut(old);
	    
	    baos = new ByteArrayOutputStream();
	    ps = new PrintStream(baos);
	    System.setOut(ps);
	    singleObject2.showMessage();
	    assertEquals(message, baos.toString().replace("\r\n", ""));
	    System.setOut(old);
	}
}
