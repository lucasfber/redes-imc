package br.ufc.imc.net.cliente;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ClienteIMCListener implements Runnable{

	private Scanner leitor; 
	
	public ClienteIMCListener(InputStream inputStream) {
		leitor = new Scanner(inputStream);
	}

	@Override
	public void run() {
		while(leitor.hasNextLine()){
			System.out.println(leitor.nextLine());
		}
	}

}
