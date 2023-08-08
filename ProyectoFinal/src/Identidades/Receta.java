package Identidades;

public class Receta {
	private int idReceta;
	private Medicamento[] listaMedicamentos;
	
	public Receta(int idReceta,Medicamento[] listaMedicamentos) {
		this.setIdReceta(idReceta);
		this.setListaMedicamentos(listaMedicamentos);
	}
	
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public Medicamento[] getListaMedicamentos() {
		return listaMedicamentos;
	}
	public void setListaMedicamentos(Medicamento[] listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

}
