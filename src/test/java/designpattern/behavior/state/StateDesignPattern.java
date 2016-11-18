package designpattern.behavior.state;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StateDesignPattern {

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
	public void testStatePattern() {
		Context context = new Context();
		
		StartState startState = new StartState();
		startState.doAction(context);
		System.out.println(context.getState().toString());
		
		StopState stopState = new StopState();
		stopState.doAction(context);
		System.out.println(context.getState().toString());
		
		String message = "Player is in start state\r\n" +
							"Start State\r\n" +
							"Player is in stop state\r\n" +
							"Stop State\r\n";
		assertEquals(message, baos.toString());
	}
}