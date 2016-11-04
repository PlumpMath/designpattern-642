package designpattern.creational.factorymethod;

public class FactoryPessoa {
	
	public Pessoa getPessoa(String nome, String sexo) {
		if(sexo.equalsIgnoreCase("H")) {
			return new Homem(nome);
		}
		
		return new Mulher(nome);
	}

}
