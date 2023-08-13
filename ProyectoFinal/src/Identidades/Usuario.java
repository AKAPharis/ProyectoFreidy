package Identidades;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private Documentacion documento;
	private String contraseña;
	
	public Usuario(String nombre,String apellido, Documentacion documento,String contraseña) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDocumento(documento);
		this.setContraseña(contraseña);
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
