package designpattern.creational.prototype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShapeTest {

	@Test
	public void testPrototype() {
		ShapeCache.loadCache();
		
		Shape clonedCircle = (Shape) ShapeCache.getShape("1"); // it's a circle
	    clonedCircle.setType("wrong type circle");

	    Shape clonedSquare = (Shape) ShapeCache.getShape("2"); // it's a square
	    clonedSquare.setType("wrong type rectangle");
	    
	    Shape clonedRectangle = (Shape) ShapeCache.getShape("2"); // it's a rectangle
	    clonedRectangle.setType("wrong type square");
	    
	    assertEquals("Circle", ShapeCache.getShape("1").getType());
	    assertEquals("Square", ShapeCache.getShape("2").getType());
	    assertEquals("Rectangle", ShapeCache.getShape("3").getType());
	}
}
