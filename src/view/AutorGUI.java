/**
 * Classe para representar um cadastro de autores
 * criado em 10/11/2020
 * @author Carlos, Janaina, Lucas, Mayara, Priscila e Sandra.
 */


package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private JTextField textEmail;
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblTipo;
	private JComboBox comboBox;
	private JButton btnEnviar;
	private JButton btnLimpar;
	
	/**
	 * Construtor completo
	 * 
	 * @param contentPan
	 * @param textCodigo
	 * @param textNome
	 * @param textEmail
	 * @param lblCodigo
	 * @param lblNome
	 * @param lblEmail
	 * @param lblTipo
	 * @param comboBox
	 * @param btnEnviar
	 * @param btnLimpar
	 */
	
	public AutorGUI() {
		Handler ouvinte = new Handler();
		setTitle("CADASTRO DE AUTORES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigo.setBounds(52, 25, 70, 21);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(52, 57, 177, 30);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(52, 98, 70, 21);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(52, 130, 177, 30);
		contentPane.add(textNome);
		
		lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(52, 173, 70, 21);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(52, 205, 177, 30);
		contentPane.add(textEmail);
		
		lblTipo = new JLabel("TIPO DE ESCRITA");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(52, 248, 115, 21);
		contentPane.add(lblTipo);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE UM ITEM", "LITERATURA INFANTIL", "LITERATURA JUVENIL", "LITERATURA ADULTO"}));
		comboBox.setBounds(52, 280, 177, 22);
		contentPane.add(comboBox);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(151, 331, 89, 23);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(ouvinte);
		
		btnLimpar = new JButton("LIMPAR");					
		btnLimpar.setBounds(52, 331, 89, 23);
		contentPane.add(btnLimpar);
		btnLimpar.addActionListener(ouvinte);
		
		setVisible(true);
	}
	/**
	 * Método para limpar campos 
	 * 
	 */
		public void limpar() {
			textCodigo.setText("");
			textNome.setText("");
			textEmail.setText("");
			comboBox.setSelectedIndex(0);
		}
		
		/**
		 * Classe interna para tratamento de evento de botões 
		 * 
		 *
		 */
		public class Handler implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLimpar) {
					limpar();
				}
				else {
					if(e.getSource()==btnEnviar) {
						String codigo = textCodigo.getText();
						String nome = textNome.getText();
						String email = textEmail.getText();
						String tipoEscrita = comboBox.getSelectedItem().toString();
						if((codigo.equals(""))|| (nome.equals(""))|| (email.equals(""))||(tipoEscrita.equals("SELECIONE UM ITEM"))) {
							JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "ATENÇÃO!!", 2, null);
						}
						else {
							if((!codigo.equals("")) && (!nome.equals("")) && (!email.equals(""))&&(!tipoEscrita.equals("SELECIONE UM ITEM"))) {
								JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!", "SUCESSO!!", 1, null);
							}
						}
					}
				}
				
			}
			
		}
	
	
}
