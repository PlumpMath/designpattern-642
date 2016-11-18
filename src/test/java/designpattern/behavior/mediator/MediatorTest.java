package designpattern.behavior.mediator;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MediatorTest {

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
	public void testMediatorDesignPattern() {
		User pablo = new User("pablo");
		User joao = new User("joao");
		
		pablo.sendMessage("Eae jao, tudo blz?");
		joao.sendMessage("Eae Pablaao, tudo suave!");
		
		String messagePablo = "[pablo] : Eae jao, tudo blz?\r\n";
		String messageJoao = "[joao] : Eae Pablaao, tudo suave!\r\n";
		
		assertTrue(baos.toString().contains(messagePablo));
		assertTrue(baos.toString().contains(messageJoao));
	}
}
