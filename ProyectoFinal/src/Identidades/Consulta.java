package Identidades;

import java.io.File;
import java.sql.Date;

public class Consulta {
	
	private int idConsulta;
	private Date fecha;
	private Paciente paciente;
	private File Receta;
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public File getReceta() {
		return Receta;
	}
	public void setReceta(File receta) {
		Receta = receta;
	}
}
