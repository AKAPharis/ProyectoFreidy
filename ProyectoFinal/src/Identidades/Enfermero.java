package Identidades;

public class Enfermero extends Usuario {
	private int idEnferma;
	private String Grado;
	
	public Enfermero() {
		super();
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
