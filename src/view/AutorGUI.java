package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AutorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textField;

	
	public AutorGUI() {
		setTitle("CADASTRO DE AUTORES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigo.setBounds(52, 25, 70, 21);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(52, 57, 177, 30);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(52, 98, 70, 21);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(52, 130, 177, 30);
		contentPane.add(textNome);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(52, 173, 70, 21);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(52, 205, 177, 30);
		contentPane.add(textField);
		
		JLabel lblTipo = new JLabel("TIPO DE ESCRITA");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(52, 248, 115, 21);
		contentPane.add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"LITERATURA INFANTIL", "LITERATURA JUVENIL", "LITERATURA ADULTO"}));
		comboBox.setBounds(52, 280, 177, 22);
		contentPane.add(comboBox);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(151, 331, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(52, 331, 89, 23);
		contentPane.add(btnLimpar);
		
		setVisible(true);
	}
}
