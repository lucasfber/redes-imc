package br.ufc.imc.net.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;

import br.ufc.imc.calculadora.CalculadoraIMC;
import br.ufc.imc.modelo.Pessoa;
import br.ufc.imc.modelo.Resultado;

public class ServidorIMCListener implements Runnable{

	private ObjectInputStream entrada;
	private PrintStream saida;
	
	public ServidorIMCListener(ObjectInputStream ois, PrintStream ps) {
		this.entrada = ois;
		this.saida = ps;
	}

	@Override
	public void run() {
		
		while(true){
			try {
				Pessoa pessoa = (Pessoa) entrada.readObject();
				Resultado resultado = CalculadoraIMC.obterIMC(pessoa.getPeso(), pessoa.getAltura());
				
				saida.println(resultado.getValorIMC() + " - " + resultado.getSituacao());
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
			
	}

}
