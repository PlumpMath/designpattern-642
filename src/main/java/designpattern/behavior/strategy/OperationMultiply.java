package designpattern.behavior.strategy;

public class OperationMultiply implements Strategy {

	public int doOperation(int number1, int number2) {
		return number1 * number2;
	}
}
