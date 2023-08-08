package Identidades;

public class Medicamento {
	private String nombreMedicamento;
	private int cantidad;
	
	public Medicamento(String nombreMedicamento,int cantidad) {
		this.setNombreMedicamento(nombreMedicamento);
		this.setCantidad(cantidad);
	}
	
	public String getNombreMedicamento() {
		return nombreMedicamento;
	}
	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
