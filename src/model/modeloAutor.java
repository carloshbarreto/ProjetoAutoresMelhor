package model;

public class modeloAutor {
	
	private String codigo;
	private String nome;
	private String email;
	private String tipoEscrita;
	
	public modeloAutor() {}
	
	public modeloAutor(String codigo, String nome, String email, String tipoEscrita) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.tipoEscrita = tipoEscrita;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getTipoEscrita() {
		return tipoEscrita;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTipoEscrita(String tipoEscrita) {
		this.tipoEscrita = tipoEscrita;
	}
	
	

}
