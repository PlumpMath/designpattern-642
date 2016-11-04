package designpattern.structural.adapter;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdapterTest {

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
	
	@Test
	public void testAdapter() {
		String message = "Conectado entrada PS2";
		
		EntradaPS2 entradaPS2 = new EntradaPS2();
		AdapterEntrada adaptador = new AdapterEntrada(entradaPS2);
		adaptador.conectarEntradaUSB();
		
	    assertEquals(message, baos.toString().replace("\r\n", ""));
	}
	
}
