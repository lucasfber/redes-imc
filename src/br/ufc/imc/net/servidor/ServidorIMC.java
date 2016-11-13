package br.ufc.imc.net.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import br.ufc.imc.calculadora.CalculadoraIMC;
import br.ufc.imc.modelo.Pessoa;
import br.ufc.imc.modelo.Resultado;
import br.ufc.imc.net.cliente.ClienteIMCListener;

public class ServidorIMC {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			ServerSocket servidor = new ServerSocket(5000);
			System.out.println("SERVIDOR RODANDO !");
			while(true){
				Socket cliente = servidor.accept();
				PrintStream ps = new PrintStream(cliente.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				
				new Thread(new ServidorIMCListener(ois, ps)).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
