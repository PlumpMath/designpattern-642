package designpattern.behavior.visitor;

public class Computer implements ComputerPart {
	
	ComputerPart[] parts;
	
	public Computer() {
		parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
	}
	
	public void accept(ComputerPartVisitor computerPartVisitor) {
		for(ComputerPart part : parts) {
			part.accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}
}
