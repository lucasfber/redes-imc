package br.ufc.imc.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.imc.calculadora.CalculadoraIMC;
import br.ufc.imc.modelo.Resultado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCliente() {
		configurarRede();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformeOSeu = new JLabel("Informe o seu peso em Kg:");
		lblInformeOSeu.setBounds(27, 79, 188, 15);
		contentPane.add(lblInformeOSeu);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(222, 77, 156, 19);
		contentPane.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JLabel lblInformeASua = new JLabel("Informe a sua altura em metros:");
		lblInformeASua.setBounds(27, 149, 229, 15);
		contentPane.add(lblInformeASua);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(263, 147, 114, 19);
		contentPane.add(textFieldAltura);
		
		JButton botaoCalcularIMC = new JButton("Calcular IMC");
		botaoCalcularIMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double peso = Double.valueOf(textFieldPeso.getText());
				double altura = Double.valueOf(textFieldAltura.getText());
				limparCampos();
				
				Resultado calculo = CalculadoraIMC.obterIMC(peso, altura);
				JOptionPane.showMessageDialog(null, calculo.getValorIMC() + " - " + calculo.getSituacao());
			}
		});
		
		botaoCalcularIMC.setBounds(278, 207, 145, 25);
		contentPane.add(botaoCalcularIMC);
	}
	
	private void limparCampos(){
		textFieldAltura.setText("");
		textFieldPeso.setText("");
	}
	
	private void configurarRede(){
		Socket cliente;
		String ip = JOptionPane.showInputDialog("IP do servidor");
		try {
			cliente = new Socket(ip, 5000);
			Scanner leitura = new Scanner(cliente.getInputStream());
			Scanner teclado = new Scanner(System.in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
