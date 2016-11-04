package designpattern.creational.abstractfactory;

public class FabricaFiat implements Fabrica {

	public CarroSedan criaCarroSedan() {
		return new Siena();
	}

	public CarroPopular criaCarroPopular() {
		return new Palio();
	}


}
