package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	private final static String url = "jdbc:sqlserver://localhost:1433;databaseName=bdAutores";
	private final static String userName = "jana";
	private final static String password = "jana";
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(url, userName, password);
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados", "Erro", 2);
			
		} return null;
		
	}
	
	public static void CloseConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
				
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao finalizar a conexão com o banco de dados", "Erro", 2);
				
			} 
		}
		
	}
	public static void CloseConnection(Connection con, PreparedStatement pst) {
		CloseConnection(con);
		if (pst != null) {
			try {
				pst.close();
				
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao finalizar a conexão com o banco de dados", "Erro", 2);
				
			} 
		}
		
	}
	

	
}
