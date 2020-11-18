package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.modeloAutor;

public class AutorDao {
	public int create(modeloAutor autor) {
		Connection con = null;
		PreparedStatement pst = null;
		String sqlInsert = "INSERT INTO Autores (Codigo, Nome, Email, TipoEscrita) VALUES (?,?,?,?)";
		
		con = ConnectionFactory.getConnection();
		
		try{
			pst = con.prepareStatement(sqlInsert);
			pst.setString(1, autor.getCodigo());
			pst.setString(2, autor.getNome());
			pst.setString(3, autor.getEmail());
			pst.setString(4, autor.getTipoEscrita());
			pst.execute();
			return 1;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de inserção dos dados do Autor"+e.getMessage(), "Erro", 2);
			return 0;
		}
		finally {
			ConnectionFactory.CloseConnection(con, pst);
		}
	}
	

}
