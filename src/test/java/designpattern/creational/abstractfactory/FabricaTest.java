package designpattern.creational.abstractfactory;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class FabricaTest {

	@Test
	public void testFabricaCarrosFiat() {
		
		Fabrica fabrica = new FabricaFiat();
		
		CarroPopular popular = fabrica.criaCarroPopular();
		CarroSedan sedan = fabrica.criaCarroSedan();
		
		assertTrue(popular instanceof Palio);
		assertTrue(sedan instanceof Siena);
	}
	
	@Test
	public void testFabricaCarrosChevrolet() {
		
		Fabrica fabrica = new FabricaChevrolet();
		
		CarroPopular popular = fabrica.criaCarroPopular();
		CarroSedan sedan = fabrica.criaCarroSedan();
		
		assertTrue(popular instanceof Celta);
		assertTrue(sedan instanceof Camaro);
	}
}
