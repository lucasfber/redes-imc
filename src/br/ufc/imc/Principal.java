package br.ufc.imc;

import java.util.Scanner;

import br.ufc.imc.calculadora.CalculadoraIMC;
import br.ufc.imc.modelo.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		double peso = teclado.nextDouble();
		double altura = 1.60;
		
		Pessoa p = new Pessoa(peso,altura);
		
		System.out.println(p.getPeso());
	}
	
}
