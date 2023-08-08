package Identidades;

public class Enfermero extends Usuario {
	private int idEnferma;
	private String Grado;
	
	public Enfermero(int idEnferma,String Grado,String nombre, String apellido, Documentacion documento,String contraseña) {
		super(nombre,apellido, documento,contraseña);
		this.setIdEnferma(idEnferma);
		this.setGrado(Grado);
	}
	
	public int getIdEnferma() {
		return idEnferma;
	}
	public void setIdEnferma(int idEnferma) {
		this.idEnferma = idEnferma;
	}

	public String getGrado() {
		return Grado;
	}
	public void setGrado(String grado) {
		Grado = grado;
	}

}
