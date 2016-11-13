package designpattern.behavior.command;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandDesignPatternTest {
	
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
	public void testCommandDesignPattern() {
		Stock abcStock = new Stock();
		
		BuyStock buyABCStockOrder = new BuyStock(abcStock);
		SellStock sellABCStockOrder = new SellStock(abcStock);
		
		Brocker brocker = new Brocker();
		brocker.takeOrder(buyABCStockOrder);
		brocker.takeOrder(sellABCStockOrder);
		
		brocker.placeOrders();
		
		String message = "Stock [ Name: ABC, Quantity: 10 ] bought\r\nStock [ Name: ABC, Quantity: 10 ] sold\r\n";
		
		assertEquals(message, baos.toString());
	}
}
