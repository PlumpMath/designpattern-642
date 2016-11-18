package designpattern.behavior.observer;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObserverPatternDemo {

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
	public void testObserverDesignPattern() {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
		
		String message = "First state change: 15\r\n" +
							"Hex String: F\r\n" +
							"Octal String: 17\r\n" +
							"Binary string:1111\r\n" +
							"Second state change: 10\r\n" +
							"Hex String: A\r\n" +
							"Octal String: 12\r\n" +
							"Binary string:1010\r\n";
		
		assertEquals(message, baos.toString());
	}

}
