package Identidades;

public class Paciente {
	private int idPaciente;
	private Documentacion documento;
	private String nombre;
	private String apellido;
	private String estado;
	private boolean interno;
	private Medico medicoEncargago;
	private Habitacion habitacion;
	
	public Paciente(int idPaciente,Documentacion documento,String nombre,String apellido,String estado,boolean interno,Medico medicoEncargago) {
		this.setIdPaciente(idPaciente);
		this.setDocumento(documento);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEstado(estado);
		this.setInterno(interno);
		this.setMedicoEncargago(medicoEncargago);
	}
	
	
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getIdPaciente() {
		return idPaciente;
	}


	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}


	public Habitacion getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
}
