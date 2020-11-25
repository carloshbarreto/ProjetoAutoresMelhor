package controller;

import java.util.ArrayList;
import java.util.List;
import dao.AutorDao;
import model.modeloAutor;

public class controllerAutor {
	
	public int cadastrar(String codigo, String nome, String email, String tipoEscrita) {
		modeloAutor a = new modeloAutor(codigo, nome, email, tipoEscrita);
		AutorDao d = new AutorDao();
		return (d.create(a));	
		
	}
	
	
	public List<modeloAutor> consultar(){
		List<modeloAutor> lista = new ArrayList<>();
		AutorDao d = new AutorDao();
		lista = d.read();
		return(lista);
	}

}
