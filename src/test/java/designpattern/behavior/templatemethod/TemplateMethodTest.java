package designpattern.behavior.templatemethod;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TemplateMethodTest {
	
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
	public void testTemplateMethodDesignPattern() {
		Game game = new Cricket();
		game.play();
		
		System.out.println();
		
		game = new Football();
		game.play();
		
		String message = "Cricket game Initialized! Start playing.\r\n" +
							"Cricket game Started! Enjoy the game.\r\n" +
							"Cricket game Finished!\r\n" +
							"\r\n" +
							"Football game Initialized! Start playing.\r\n" +
							"Football game Started! Enjoy the game.\r\n" +
							"Football game Finished!\r\n";
		assertEquals(message, baos.toString());
	}
	
}
