package designpattern.creational.abstractfactory;

public class FabricaChevrolet implements Fabrica {

	public CarroSedan criaCarroSedan() {
		return new Camaro();
	}

	public CarroPopular criaCarroPopular() {
		return new Celta();
	}

}
