package Identidades;
							
public class Habitacion {
	private int noHabitacion;
	private Enfermero encargado;
	
	public Habitacion(int noHabitacion,Enfermero encargado) {
		this.setNoHabitacion(noHabitacion);
		this.setEncargado(encargado);
	}
	
	public int getNoHabitacion() {
		return noHabitacion;
	}
	public void setNoHabitacion(int noHabitacion) {
		this.noHabitacion = noHabitacion;
	}
	public Enfermero getEncargado() {
		return encargado;
	}
	public void setEncargado(Enfermero encargado) {
		this.encargado = encargado;
	}
}
