package designpattern.structural.flyweight;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FlyweightDesignPatternTest {
	
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black"};
	
	@Test
	public void shapeFlyweightTest() {
		
		for(int i=0; i < 20; ++i) {
	         Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
	         circle.setX(getRandomX());
	         circle.setY(getRandomY());
	         circle.setRadius(100);
	         circle.draw();
	    }
		
		assertEquals(5, ShapeFactory.getNumberCircleObjects());
	}
	
	private static String getRandomColor() {
	      return colors[(int)(Math.random()*colors.length)];
	}
	
	private static int getRandomX() {
	     return (int)(Math.random()*100 );
	}
	
	private static int getRandomY() {
	   return (int)(Math.random()*100);
	}

}
