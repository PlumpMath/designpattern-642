package designpattern.structural.adapter;

public class AdapterEntrada extends EntradaUSB {
	
	private EntradaPS2 entradaPS2;
	
	public AdapterEntrada(EntradaPS2 entradaPS2) {
		this.entradaPS2 = entradaPS2;
	}
	
	public void conectarEntradaUSB() {
		this.entradaPS2.conectarEntradaPS2();
	}

}
