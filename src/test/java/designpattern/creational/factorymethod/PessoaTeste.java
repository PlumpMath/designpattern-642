package designpattern.creational.factorymethod;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PessoaTeste {

	@Test
	public void testCriaPessoas() {
		
		String nomeHomem = "Pablo";
		String sexoHomem = "h";
		
		String nomeMulher = "Juliana";
		String sexoMulher = "m";
		
		FactoryPessoa fabricaPessoas = new FactoryPessoa();
		
		Pessoa homem = fabricaPessoas.getPessoa(nomeHomem, sexoHomem);
		Pessoa mulher = fabricaPessoas.getPessoa(nomeMulher, sexoMulher);
		
		assertThat(homem, instanceOf(Pessoa.class));
		assertThat(homem, instanceOf(Homem.class));
		assertThat(mulher, instanceOf(Mulher.class));
	}
}
