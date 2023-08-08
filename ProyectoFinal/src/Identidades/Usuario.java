package Identidades;

public abstract class Usuario {
	private String nombre;
	private Documentacion documento;
	private String contraseña;
	
	public Usuario(String nombre,Documentacion documento,String contraseña) {
		this.setNombre(nombre);
		this.setDocumento(documento);
		this.setContraseña(contraseña);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Documentacion getDocumento() {
		return documento;
	}
	public void setDocumento(Documentacion documento) {
		this.documento = documento;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
