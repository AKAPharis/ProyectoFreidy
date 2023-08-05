package Identidades;

public class Medico extends Usuario {
	
	private int idMedico;
	private String Exequatur;
	private String Especializacion;
	
	public Medico(){
		super();
	}
	
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public String getExequatur() {
		return Exequatur;
	}
	public void setExequatur(String exequatur) {
		Exequatur = exequatur;
	}
	public String getEspecializacion() {
		return Especializacion;
	}
	public void setEspecializacion(String especializacion) {
		Especializacion = especializacion;
	}
}
