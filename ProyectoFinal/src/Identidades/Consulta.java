package Identidades;

import java.sql.Date;

public class Consulta {
	
	private int idConsulta;
	private Date fecha;
	private Paciente paciente;
	private Receta receta;
	private Medico encargado;
	private int[] diagnostico;
	
	public Consulta(int idConsulta,Date fecha,Paciente paciente,Receta receta) {
		this.setIdConsulta(idConsulta);
		this.setFecha(fecha);
		this.setPaciente(paciente);
		this.setReceta(receta);
	}
	
	
	public Consulta(int idConsulta,Date fecha,Paciente paciente) {
		this.setIdConsulta(idConsulta);
		this.setFecha(fecha);
		this.setPaciente(paciente);
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


	public int[] getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(int[] diagnostico) {
		this.diagnostico = diagnostico;
	}


	public Medico getEncargado() {
		return encargado;
	}


	public void setEncargado(Medico encargado) {
		this.encargado = encargado;
	}
}
