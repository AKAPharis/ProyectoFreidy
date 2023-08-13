package Identidades;

import java.util.Date;

public class Consulta {
	
	private int idConsulta;
	private Date fecha;
	private Paciente paciente;
	private Receta receta;
	private Medico encargado;
	private Object[] diagnostico;
	
	public Consulta(int idConsulta,Date fecha,Paciente paciente,Receta receta,Medico encargado,Object[] diagnostico) {
		this.setIdConsulta(idConsulta);
		this.setFecha(fecha);
		this.setPaciente(paciente);
		this.setReceta(receta);
		this.setEncargado(encargado);
		this.setDiagnostico(diagnostico);
	}
	
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


	public Object[] getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(Object[] diagnostico) {
		this.diagnostico = diagnostico;
	}


	public Medico getEncargado() {
		return encargado;
	}


	public void setEncargado(Medico encargado) {
		this.encargado = encargado;
	}
}
