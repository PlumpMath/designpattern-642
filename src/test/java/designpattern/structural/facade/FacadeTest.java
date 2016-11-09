package designpattern.structural.facade;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FacadeTest {

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
	public void draw() {
		System.out.println("Circle::draw()");
	}
	
	@Test
	public void testFacadeDrawCircle() {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		
		String message = "Circle::draw()\r\n";
		
		assertEquals(message, baos.toString());
	}
	
	@Test
	public void testFacadeDrawRectangle() {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawRectangle();
		
		String message = "Rectangle::draw()\r\n";
		
		assertEquals(message, baos.toString());
	}
	
	@Test
	public void testFacadeDrawSquare() {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawSquare();
		
		String message = "Square::draw()\r\n";
		
		assertEquals(message, baos.toString());
	}
	
	@Test
	public void testFacadeDrawAllTogether() {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
		
		String message = "Circle::draw()\r\n" +
				"Rectangle::draw()\r\n" +
				"Square::draw()\r\n";
		
		assertEquals(message, baos.toString());
	}
}
