package Identidades;

public class Paciente {
	
	private Documentacion documento;
	private String nombre;
	private String estado;
	private boolean interno;
	private Medico medicoEncargago;
	
	public Documentacion getDocumento() {
		return documento;
	}
	public void setDocumento(Documentacion documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isInterno() {
		return interno;
	}
	public void setInterno(boolean interno) {
		this.interno = interno;
	}
	public Medico getMedicoEncargago() {
		return medicoEncargago;
	}
	public void setMedicoEncargago(Medico medicoEncargago) {
		this.medicoEncargago = medicoEncargago;
	}
	
}
