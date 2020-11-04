package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField txtSenha;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JButton btnEntrar;
	private JButton btnLimpar;
	

	
	public LoginGUI() {
		
		Handler ouvinte = new Handler();
		setTitle("TELA DE LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(65, 21, 70, 22);
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setBounds(65, 54, 200, 32);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(65, 97, 70, 22);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(65, 130, 200, 32);
		contentPane.add(txtSenha);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(176, 187, 89, 23);
		btnEntrar.addActionListener(ouvinte);
		contentPane.add(btnEntrar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(65, 187, 89, 23);
		btnLimpar.addActionListener(ouvinte);
		contentPane.add(btnLimpar);
		
		
		
		setVisible(true);
	}
	
	public void limpar() {
		textLogin.setText("");
		txtSenha.setText("");
	}
	
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnLimpar) {
				limpar();
			}
			else {
				if(e.getSource()==btnEntrar) {
					String login = textLogin.getText();
					String senha = String.valueOf(txtSenha.getPassword());
					
					if((login.equals(""))|| (senha.equals(""))) {
						JOptionPane.showMessageDialog(getContentPane(), "Todos os campos devem ser preenchidos", "Atenção!",  1);
					}
					
					else {
						if((login.equals("user"))|| (senha.equals("12345"))) {
							dispose();
							AutorGUI autr = new AutorGUI();
							
						}
						
						else {
							JOptionPane.showMessageDialog(getContentPane(), "USUÁRIO E/OU SENHA INCORRETOS", "Atenção!",  1);
						}
					}
				}
			}
		}
		
	}
}
