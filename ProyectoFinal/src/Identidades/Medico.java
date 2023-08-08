package Identidades;

public class Medico extends Usuario {
	
	private int idMedico;
	private String exequatur;
	private String especializacion;
	
	public Medico(int idMedico,String exequatur,String especializacion,String nombre,Documentacion documento,String contraseña){
		super(nombre,documento,contraseña);
		this.setIdMedico(idMedico);
		this.setExequatur(exequatur);
		this.setEspecializacion(especializacion);
	}
	
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public String getExequatur() {
		return exequatur;
	}
	public void setExequatur(String exequatur) {
		this.exequatur = exequatur;
	}
	public String getEspecializacion() {
		return especializacion;
	}
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
}
