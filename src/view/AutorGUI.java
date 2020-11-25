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
import javax.swing.table.DefaultTableModel;

import controller.controllerAutor;
import model.modeloAutor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

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
	private JTable tabelaAutores;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JSeparator separator;
	
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
		setBounds(100, 100, 326, 602);
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
		
		separator = new JSeparator();
		separator.setBounds(0, 397, 310, 2);
		contentPane.add(separator);
		
		definirJTable();
		
		
		scrollPane = new JScrollPane(tabelaAutores);
		scrollPane.setBounds(10, 410, 290, 142);
		contentPane.add(scrollPane);
		
		
		setVisible(true);
	}
	/**
	 * M�todo para limpar campos 
	 * 
	 */
		public void limpar() {
			textCodigo.setText("");
			textNome.setText("");
			textEmail.setText("");
			comboBox.setSelectedIndex(0);
		}
		
		
		public void definirJTable() {
			modelo = new DefaultTableModel();
			modelo.addColumn("C�digo");
			modelo.addColumn("Nome");
			modelo.addColumn("E-mail");
			modelo.addColumn("Tipo de Escrita");
			tabelaAutores = new JTable(modelo);
		}
		
		
		public void adicionarAutor(List<modeloAutor> lista) {
			modelo.setNumRows(0);
			
				for(modeloAutor user: lista) {
					Object[] linha = {user.getCodigo(), user.getNome(), user.getEmail(), user.getTipoEscrita()};
					modelo.addRow(linha);
					}
		}
		
		
		/**
		 * Classe interna para tratamento de evento de bot�es 
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
							JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!", "ATEN��O!!", 2, null);
						}
						else {
							controllerAutor ca = new controllerAutor();
							
							if(ca.cadastrar(codigo, nome, email, tipoEscrita)==1) {
								JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!", "SUCESSO!!", 1, null);
								limpar();
								scrollPane.setVisible(true);
								adicionarAutor(ca.consultar());
								
							}
							else {
								JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar!", "ATEN��O!!", 2, null);
							}
						}
					}
				}
				
			}
			
		}
}
