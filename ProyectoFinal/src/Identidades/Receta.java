package Identidades;

import java.util.List;

public class Receta {
	private int idReceta;
	private List<Medicamento> listaMedicamentos;
	
	public Receta(int idReceta,List<Medicamento> listaMedicamentos) {
		this.setIdReceta(idReceta);
		this.setListaMedicamentos(listaMedicamentos);
	}
	
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}
	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

}
