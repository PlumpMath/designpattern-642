package designpattern.behavior.interpreter;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterpreterTest {
	
	@Test
	public void testInterpreterDesignPattern() {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		
		String questionJohnIsMale = "John is male? " + isMale.interpret("John");
		String questionJulieIsMarried = "Julie is a married woman? " + isMarriedWoman.interpret("Married Julie");
		
		assertEquals(questionJohnIsMale, "John is male? true");
		assertEquals(questionJulieIsMarried, "Julie is a married woman? true");
	}
	
	public Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}
	
	public Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}
}
