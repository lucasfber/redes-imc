package br.ufc.imc.net.cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import br.ufc.imc.modelo.Pessoa;

public class ClienteIMC {

	public static void main(String[] args) {
		try {
			Socket cliente = new Socket("127.0.0.1", 5000);
			Scanner teclado = new Scanner(System.in);
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			new Thread(new ClienteIMCListener(cliente.getInputStream())).start();
			
			while(true){
				double peso = teclado.nextDouble();
				double altura = teclado.nextDouble();
				
				Pessoa p = new Pessoa(peso,altura);
				oos.writeObject(p);
				oos.flush();
				System.out.println("Enviou !");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
