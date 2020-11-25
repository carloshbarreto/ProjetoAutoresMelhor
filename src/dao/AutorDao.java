package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

	
	public List<modeloAutor> read(){
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Autores";
		List<modeloAutor> Autores = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
				while(rs.next()) {
					modeloAutor a = new modeloAutor();
					a.setCodigo(rs.getString("codigo"));
					a.setNome(rs.getString("nome"));
					a.setEmail(rs.getString("email"));
					a.setTipoEscrita(rs.getString("tipoEscrita"));
					Autores.add(a);
				}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			ConnectionFactory.CloseConnection(con, pst, rs);
		}
		
		return Autores;
	}

}
