package Identidades;

public class Documentacion {
	private String tipo;
	private int noDocumento;
	
	public Documentacion(String tipo,int noDocumento) {
		this.setTipo(tipo);
		this.setNoDocumento(noDocumento);
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNoDocumento() {
		return noDocumento;
	}
	public void setNoDocumento(int noDocumento) {
		this.noDocumento = noDocumento;
	}
	
}

