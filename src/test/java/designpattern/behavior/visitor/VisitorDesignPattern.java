package designpattern.behavior.visitor;

import org.junit.Test;

public class VisitorDesignPattern {
	
	@Test
	public void testVisitorPattern() {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
	
}
