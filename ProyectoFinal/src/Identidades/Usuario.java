package Identidades;

public abstract class Usuario {
	private String Nombre;
	private Documentacion Documento;
	private String contraseña;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Documentacion getDocumento() {
		return Documento;
	}
	public void setDocumento(Documentacion documento) {
		Documento = documento;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
