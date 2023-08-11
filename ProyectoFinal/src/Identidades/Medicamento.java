package Identidades;

public class Medicamento {
	private int idMedicamento;
	private String nombreMedicamento;
	private int cantidad;
	
	public Medicamento(int idMedicamento,String nombreMedicamento,int cantidad) {
		this.setIdMedicamento(idMedicamento);
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

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	
}
