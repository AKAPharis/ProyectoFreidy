package Identidades;

import java.sql.Date;

public class Consulta {
	
	private int idConsulta;
	private Date fecha;
	private Paciente paciente;
	private Receta receta;
	
	public Consulta(int idConsulta,Date fecha,Paciente paciente,Receta receta) {
		this.setIdConsulta(idConsulta);
		this.setFecha(fecha);
		this.setPaciente(paciente);
		this.setReceta(receta);
	}
	
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
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
}
