package designpattern.behavior.memento;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MementoTest {
	
	@Test
	public void testMementoDesignPattern() {
		Originator originator = new Originator();
		originator.setState("qq estado");
		
		CareTaker careTaker = new CareTaker();
		
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());
		String firstState = originator.getState();
		
		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());
		String secondState = originator.getState();
		
		String currentState = "State #4";
		originator.setState(currentState);
		
		assertEquals(currentState, originator.getState());
		
		originator.getStateFromMemento(careTaker.get(0));
		assertEquals(firstState, originator.getState());
		
		originator.getStateFromMemento(careTaker.get(1));
		assertEquals(secondState, originator.getState());
	}
}
