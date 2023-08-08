package Identidades;

import java.sql.Date;

public class Cita {
	
	private int id;
	private Date fecha;
	private Consulta consulta;
	
	public Cita(int id,Date fecha,Consulta consulta) {
		this.setId(id);
		this.setFecha(fecha);
		this.setConsulta(consulta);
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
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
}
