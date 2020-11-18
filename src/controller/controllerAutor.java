package controller;

import dao.AutorDao;
import model.modeloAutor;

public class controllerAutor {
	public int cadastrar(String codigo, String nome, String email, String tipoEscrita) {
		modeloAutor a = new modeloAutor(codigo, nome, email, tipoEscrita);
		AutorDao d = new AutorDao();
		return (d.create(a));
		
		
	}
	

}
