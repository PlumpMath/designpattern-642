package designpattern.behavior.strategy;

public class OperationSubtract implements Strategy {

	public int doOperation(int number1, int number2) {
		return number1 - number2;
	}
}
