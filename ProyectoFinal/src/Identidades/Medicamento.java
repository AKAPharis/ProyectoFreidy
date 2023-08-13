package Identidades;

public class Medicamento {
	private int idMedicamento;
	private String nombreMedicamento;
	private int cantidad;
	private String principioActivo;
	private String marca;
	private String fabricante;
	
	public Medicamento(int idMedicamento,String nombreMedicamento,int cantidad) {
		this.setIdMedicamento(idMedicamento);
		this.setNombreMedicamento(nombreMedicamento);
		this.setCantidad(cantidad);
	}
	public Medicamento(int idMedicamento,String nombreMedicamento,String principioActivo,String marca,String fabricante,int cantidad) {
		this.setIdMedicamento(idMedicamento);
		this.setNombreMedicamento(nombreMedicamento);
		this.setPrincipioActivo(principioActivo);
		this.setMarca(marca);
		this.setFabricante(fabricante);
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

	public String getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo) {
		this.principioActivo = principioActivo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
}
