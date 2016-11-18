package designpattern.behavior.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StrategyTest {
	
	@Test
	public void testStrategyDesignPattern() {
		int number1 = 3;
		int number2 = 7; 
		int sum = number1 + number2;
		int subtract = number1 - number2;
		int multiply = number1 * number2;

		Context context = new Context(new OperationAdd());
		assertEquals(sum, context.executeStrategy(number1, number2));
		
		context = new Context(new OperationSubtract());
		assertEquals(subtract, context.executeStrategy(number1, number2));
		
		context = new Context(new OperationMultiply());
		assertEquals(multiply, context.executeStrategy(number1, number2));
	}
}
