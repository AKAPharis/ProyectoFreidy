package Identidades;

import java.sql.Date;

public class Cita {
	
	private int id;
	private Date fecha;
	private Paciente paciente;
	private String estado;
	public Cita(int id,Date fecha,Paciente paciente,String estado) {
		this.setId(id);
		this.setFecha(fecha);
		this.setPaciente(paciente);
		this.setEstado(estado);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
