package br.ufc.imc.calculadora;

import br.ufc.imc.modelo.Resultado;

public class CalculadoraIMC {

	public static double imc;
	public static final String SITUACAO_1 = "Muito abaixo do peso";
	public static final String SITUACAO_2 = "Abaixo do peso";
	public static final String SITUACAO_3 = "Peso normal";
	public static final String SITUACAO_4 = "Acima do peso";
	public static final String SITUACAO_5 = "Obesidade I";
	public static final String SITUACAO_6 = "Obesidade II (severa)";
	public static final String SITUACAO_7 = "Obesidade III (mórbida)";
	
	
	private static double calculaIMC(double peso, double altura) {
		return peso / (altura * altura);
	}
	
	public static Resultado obterIMC(double peso, double altura){
		Resultado resultado;
		double imc = calculaIMC(peso, altura);
		
		if(imc < 17){
			resultado = new Resultado(imc, SITUACAO_1);
			return resultado;
		}
		
		else if(imc >= 17 && imc <= 18.49){
			resultado = new Resultado(imc, SITUACAO_2);
			return resultado;
		}
		
		else if(imc >= 18.50 && imc <= 24.99){
			resultado = new Resultado(imc, SITUACAO_3);
			return resultado;
		}
		
		else if(imc >= 25 && imc <= 29.99){
			resultado = new Resultado(imc, SITUACAO_4);
			return resultado;
		}
		
		else if(imc >= 30 && imc <= 34.99){
			resultado = new Resultado(imc, SITUACAO_5);
			return resultado;
		}
		
		else if(imc >= 35 && imc <= 39.99){
			resultado = new Resultado(imc, SITUACAO_6);
			return resultado;
		}
		
		else{
			resultado = new Resultado(imc, SITUACAO_7);
			return resultado;
		}
	}
	
}
