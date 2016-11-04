package designpattern.creational.factorymethod;

public class Homem extends Pessoa {
	
	public Homem(String nome) {
		this.nome = nome;
		System.out.println("Olá senhor " + this.nome);
	}
	
	public void mijandoEmPe() {
		System.out.println("estou mijando em pe");
	}

}
